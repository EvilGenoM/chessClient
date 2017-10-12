package mobi.mpk.chessandroid.ui.game_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

/**
 * Created by evgen on 10.10.17.
 */

public class Drawer {

    private Context context;
    private Canvas canvas;
    private Paint paint;

    public Drawer(Context context){
        this.context = context;
        this.canvas = new Canvas();
        paint = new Paint();
    }

    public void drawRect(int left, int top, int right, int bottom, int color){

        int colorCell = ContextCompat.getColor(context, color);
        paint.setColor(colorCell);

        canvas.drawRect(left, top, right, bottom, paint);

    }

    public void drawBitmap(int adressBitmap, int x, int y, int size){

        Bitmap bmpFull = BitmapFactory.decodeResource(context.getResources(), adressBitmap);
        Bitmap bmp = Bitmap.createScaledBitmap(bmpFull, size, size, false);

        canvas.drawBitmap(bmp, x, y, null);

    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

}
