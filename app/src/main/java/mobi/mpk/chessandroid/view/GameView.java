package mobi.mpk.chessandroid.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
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
    private Stroke stroke;

    private Paint paint;
    private Context context;
    private Canvas canvas;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        stroke = new Stroke();

        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);

        initBoard(width);

    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        this.canvas = canvas;

        boardView.onDraw();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        double x = event.getX();
        double y = event.getY();

        //.move(x, y, boardView);
        if(event.getAction() == MotionEvent.ACTION_DOWN){

            Paint panel = new Paint();
            panel.setColor(Color.BLACK);
            canvas.drawText("success", 0, 300, panel);

        }

        return super.onTouchEvent(event);
    }

    private void initBoard(int widthFull) {

        int width = widthFull;
        int height = widthFull;

        int left, right, top, bottom;

        left = 0;
        right = width;

        top = 0;
        bottom = height;

        boardView = new BoardView(left, top, right, bottom, this);

    }

    public void onDrawCell(int x, int y, int size, Colors color){

        Paint paint = new Paint();
        if(color == Colors.black) {
            int colorCell = ContextCompat.getColor(context, R.color.blackCell);
            paint.setColor(colorCell);

        } else {

            int colorCell = ContextCompat.getColor(context, R.color.whiteCell);
            paint.setColor(colorCell);

        }

        canvas.drawRect(x, y, x + size, y + size, paint);

    }

    public void onDrawFigure(int adressBitmap, int x, int y, int size){

        Bitmap bmpFull = BitmapFactory.decodeResource(context.getResources(), adressBitmap);

        Bitmap bmp = Bitmap.createScaledBitmap(bmpFull, size, size, false);

        canvas.drawBitmap(bmp, x, y, null);

    }

    public void onDrawWay(int x, int y, int radius){

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, radius, paint);

    }


}
