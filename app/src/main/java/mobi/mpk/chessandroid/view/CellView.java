package mobi.mpk.chessandroid.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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

            paint.setColor(Color.BLACK);

        } else {

            paint.setColor(Color.WHITE);

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
