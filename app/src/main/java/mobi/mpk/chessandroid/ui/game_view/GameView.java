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
import mobi.mpk.chessandroid.observer.Observer;
import mobi.mpk.chessandroid.observer.model.GameData;

public class GameView extends View implements Observer {

    private int lengthSide;

    @Inject
    Drawer drawer;
    @Inject
    GameController controller;
    @Inject
    GameData gameData;

    private BoardView boardView;
    private String stroke;
    private boolean secondTouch = false;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        App.getComponent().inject(this);
        gameData.registerObserver(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){

            if(boardView.checkFigure(x, y, controller.getColor())){

                String coordinateCell = boardView.getCoordinateCell(x, y);
                stroke = coordinateCell;

                secondTouch = true;

                invalidate();

            }else if(secondTouch){

                String coordinateCell = boardView.getCoordinateCell(x, y);
                stroke += " " + coordinateCell;

                secondTouch = false;

                controller.move(stroke);

                stroke = "";
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

    @Override
    public void update() {

        boardView.update();

        invalidate();

    }

}
