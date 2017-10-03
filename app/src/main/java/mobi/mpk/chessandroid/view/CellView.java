package mobi.mpk.chessandroid.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.domain.Color;

/**
 * Created by evgen on 03.10.17.
 */

public class CellView {

    private int left;
    private int top;

    private int right;
    private int bottom;

    public CellView(int x, int y, int size){

        this.left = x * size;
        this.top = y * size;

        this.right = this.left + size;
        this.bottom = this.top + size;

    }

    public void onDraw(Canvas canvas, Paint paint, int color){

        paint.setColor(color);

        canvas.drawRect(left, top, right, bottom, paint);

    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

}
