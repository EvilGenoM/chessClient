package mobi.mpk.chessandroid.view.figure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by evgen on 03.10.17.
 */

public interface FigureView {

    public void onDraw(int x, int y, Canvas canvas, Context context);

}
