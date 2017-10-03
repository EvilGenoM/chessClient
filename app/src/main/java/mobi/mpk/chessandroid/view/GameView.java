package mobi.mpk.chessandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.List;
import java.util.logging.Logger;

import mobi.mpk.chessandroid.domain.Board;

/**
 * Created by evgen on 03.10.17.
 */

public class GameView extends View {

    private Board board;
    private BoardView boardView;
    private StrokeView strokeView;

    private Canvas canvas;

    private int width;
    private int height;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        board = new Board();
        boardView = new BoardView(context, board);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        strokeView = new StrokeView(canvas, boardView);
        strokeView.handle(x, y);

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        this.canvas = canvas;

        boardView.onDraw(canvas);

    }

}
