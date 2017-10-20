package mobi.mpk.chessandroid.ui.game_view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.observer.Observer;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.GamePresenter;
import mobi.mpk.chessandroid.type.ResultType;

public class GameView extends View implements Observer {

    @Inject
    Drawer drawer;
    @Inject
    GameController controller;
    @Inject
    GamePresenter gamePresenter;
    @Inject
    GameData gameData;

    private AssetManager assetManager;
    private SoundPool soundPool;
    private int soundTouchFigure, soundAttack, soundMove;

    private boolean onTouchMove = false;
    private boolean onTouchDown = false;
    private int onTouchX;
    private int onTouchY;

    private BoardView boardView;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        App.getComponent().inject(this);
        gameData.registerObserver(this);
        gamePresenter.setGameView(this);

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            createOldSoundPool();
        } else {
            createNewSoundPool();
        }

        assetManager = context.getAssets();

        soundTouchFigure = loadSound("move.wav");
        soundMove = loadSound("move.wav");
        soundAttack = loadSound("move.wav");

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    @SuppressWarnings("deprecation")
    private void createOldSoundPool() {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }

    private void playSound(int sound) {
        if (sound > 0) {
            AudioManager audioManager = (AudioManager) drawer.getContext().getSystemService(Context.AUDIO_SERVICE);
            float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            float leftVolume = curVolume / maxVolume;
            float rightVolume = curVolume / maxVolume;
            soundPool.play(sound, leftVolume, rightVolume, 1, 0, 1);
        }
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = assetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(drawer.getContext().getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return soundPool.load(afd, 1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        String coordinateCell = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                coordinateCell = boardView.getCoordinateCell(x, y);
                controller.handleStroke(coordinateCell);
                if (controller.checkExistFigure(coordinateCell)) {
                    onTouchX = x;
                    onTouchY = y;
                    playSound(soundTouchFigure);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if (onTouchMove) {
                                onTouchDown = true;
                            }
                        }
                    }, 500);
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (onTouchMove == true) {
                    coordinateCell = boardView.getCoordinateCell(x, y);
                    controller.handleStroke(coordinateCell);
                    onTouchMove = false;
                }
                onTouchDown = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                onTouchMove = true;
                if (onTouchDown) {
                    boardView.moveFigure(onTouchX, onTouchY, x, y);
                    invalidate();
                }
                return true;
        }

        return false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int lengthSide;

        if (getMeasuredHeight() > getMeasuredWidth()) {
            lengthSide = getMeasuredWidth();
        } else {
            lengthSide = getMeasuredHeight();
        }

        setMeasuredDimension(lengthSide, lengthSide);
        boardView = new BoardView(lengthSide);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawer.setCanvas(canvas);
        boardView.onDrawBoard();
    }

    @Override
    public void update(ResultType resultType) {

        if (resultType == ResultType.SUCCESS){
            playSound(soundMove);
        } else if (resultType == ResultType.ATTACK) {
            playSound(soundAttack);
        }

        update();

    }

    public void update() {

        boardView.update();

        invalidate();

    }

    public void setHighlightCell(String coordinateCell) {

        boardView.setHighLightCell(coordinateCell);

    }

}
