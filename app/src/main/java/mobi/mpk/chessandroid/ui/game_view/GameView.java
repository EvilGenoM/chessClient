package mobi.mpk.chessandroid.ui.game_view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.observer.Observer;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.GamePresenter;

public class GameView extends View implements Observer {

    @Inject
    Drawer drawer;
    @Inject
    GameController controller;
    @Inject
    GamePresenter gamePresenter;
    @Inject
    GameData gameData;

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
                if(controller.checkExistFigure(coordinateCell)){
                    onTouchX = x;
                    onTouchY = y;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(onTouchMove){
                                onTouchDown = true;
                            }
                        }
                    }, 1000);
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if(onTouchMove == true){
                    coordinateCell = boardView.getCoordinateCell(x, y);
                    controller.handleStroke(coordinateCell);
                    onTouchMove = false;
                }
                onTouchDown = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                onTouchMove = true;
                if(onTouchDown) {
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
    public void update() {

        boardView.update();

        invalidate();

    }

    public void setHighlightCell(String coordinateCell) {

        boardView.setHighLightCell(coordinateCell);

    }

}
