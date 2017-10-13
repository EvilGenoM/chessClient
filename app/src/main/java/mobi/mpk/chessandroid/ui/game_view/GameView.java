package mobi.mpk.chessandroid.ui.game_view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.controller.GameController;

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
        App.getComponent().inject(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            stroke += boardView.getCoordinateCell(x, y) + " ";
            if(stroke.length() == 6){
                stroke.trim();
                controller.move(stroke);
                stroke = "";
                invalidate();
            }
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if(getMeasuredHeight() > getMeasuredWidth()){
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

}
