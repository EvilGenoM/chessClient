package mobi.mpk.chessandroid.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.view.figure.FigureView;

/**
 * Created by evgen on 04.10.17.
 */

public class CellView {

    private int x;
    private int y;
    private int size;

    private FigureView figureView;

    public CellView(int x, int y, int size, FigureView figureView){

        this.x = x;
        this.y = y;
        this.size = size;

        this.figureView = figureView;

    }

    public void onDraw(Canvas canvas, Context context){

        Paint paint = new Paint();
        if((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            int color = ContextCompat.getColor(context, R.color.blackCell);
            paint.setColor(color);

        } else {

            int color = ContextCompat.getColor(context, R.color.whiteCell);
            paint.setColor(color);

        }

        canvas.drawRect(x, y, x + size, y + size, paint);
        if(figureView != null) {
            figureView.createBitmap(context, size);
            figureView.onDraw(canvas, this);
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
