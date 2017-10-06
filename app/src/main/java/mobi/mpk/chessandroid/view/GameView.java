package mobi.mpk.chessandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.view.figure.FigureView;

/**
 * Created by evgen on 04.10.17.
 */

public class GameView extends View {

    private final int INDENT_SIDE = 50;

    private BoardView boardView;

    private Paint paint;
    private Context context;
    private Canvas canvas;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        canvas.drawText("Succes", 50, 50, paint);

        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);

    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        this.canvas = canvas;

        initBoard();

        boardView.onDraw(canvas, context);
    }

    private void initBoard() {

        int width = this.getWidth();
        int height = this.getHeight();

        int left, right, top, bottom;

        left = 0;
        right = width;

        top = 0;
        bottom = height;

        boardView = new BoardView(left, top, right, bottom, this);

    }

}
