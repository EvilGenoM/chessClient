package mobi.mpk.chessandroid.ui.game_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;


public class Drawer {

    private Context context;
    private Canvas canvas;
    private Paint paint;

    public Drawer(Context context) {
        this.context = context;
        this.canvas = new Canvas();
        paint = new Paint();
    }

    public Context getContext() {
        return context;
    }

    public void drawText(String text, int x, int y) {

        paint.setColor(Color.BLACK);

        canvas.drawText(text, x, y, paint);

    }

    public void drawRect(int left, int top, int right, int bottom, int color) {

        int colorCell = ContextCompat.getColor(context, color);
        paint.setColor(colorCell);

        canvas.drawRect(left, top, right, bottom, paint);

    }

    public void drawImg(int adress, int x, int y, int size) {

        Drawable draw = context.getResources().getDrawable(adress);
        draw.setBounds(x, y, x + size, y + size);
        draw.draw(canvas);

    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

}
