package mobi.mpk.chessandroid.view.figure;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.view.CellView;
import mobi.mpk.chessandroid.view.Colors;

/**
 * Created by evgen on 04.10.17.
 */

public abstract class FigureView {

    protected Bitmap bmp;
    protected Colors color;

    public abstract void createBitmap(Context context, int size);

    public void onDraw(Canvas canvas, CellView cellView){

        canvas.drawBitmap(bmp, cellView.getX(), cellView.getY(), null);

    }

}
