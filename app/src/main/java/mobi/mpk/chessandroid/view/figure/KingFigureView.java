package mobi.mpk.chessandroid.view.figure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.domain.Color;

/**
 * Created by evgen on 03.10.17.
 */

public class KingFigureView implements FigureView{

    private Bitmap bmp;
    private Color color;

    public KingFigureView(Color color){

        this.color = color;

    }

    @Override
    public void onDraw(int x, int y, Canvas canvas, Context context) {

        if(color == Color.white){
            bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_king);
        } else {
            bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_king);//!!!!!!!!!!!!
        }
        canvas.drawBitmap(bmp, x, y, null);

    }

}
