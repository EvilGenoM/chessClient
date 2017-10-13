package mobi.mpk.chessandroid.ui.game_view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import javax.inject.Inject;

import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.ui.MainActivity;

public class GameView extends View {

    private int lengthSide;

    @Inject
    Drawer drawer;

    @Inject
    GameController controller;

    private BoardView boardView;
    private String stroke = "";

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        MainActivity.getComponent().inject(this);
        boardView = new BoardView(lengthSide);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            stroke += boardView.getCoordinateCell(x, y) + " ";
            stroke.trim();
            if(stroke.length() == 5){
                controller.move(stroke);
            }
            invalidate();
        }

        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        lengthSide = getMeasuredWidth();
        setMeasuredDimension(lengthSide, lengthSide);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawer.setCanvas(canvas);
        boardView.onDrawBoard();
    }

}
