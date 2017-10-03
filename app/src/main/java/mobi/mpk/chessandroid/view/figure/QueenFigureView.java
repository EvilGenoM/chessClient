package mobi.mpk.chessandroid.view.figure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.domain.Color;

import static android.graphics.BitmapFactory.*;


/**
 * Created by evgen on 03.10.17.
 */

public class QueenFigureView implements FigureView{

    private Bitmap bmp;
    private Color color;

    public QueenFigureView(Color color){

        this.color = color;

    }

    @Override
    public void onDraw(int x, int y, Canvas canvas, Context context) {

        if(color == Color.white){
            bmp = decodeResource(context.getResources(), R.drawable.white_queen);
        } else {
            bmp = decodeResource(context.getResources(), R.drawable.black_queen);
        }
        canvas.drawBitmap(bmp, x, y, null);

    }

}
