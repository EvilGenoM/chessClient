package mobi.mpk.chessandroid.ui.settings;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import mobi.mpk.chessandroid.R;

public class SettingsView extends View {

    private Context context;

    public SettingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bmpFull = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_knight);
        Bitmap bmp = Bitmap.createScaledBitmap(bmpFull, 1000, 1000, false);

        canvas.drawBitmap(bmp, 0, 0, null);

    }
}
