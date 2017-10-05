package mobi.mpk.chessandroid.view.figure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.view.Colors;

/**
 * Created by evgen on 04.10.17.
 */

public class PawnView  extends FigureView {


    public PawnView( Colors color){

        this.color = color;

    }

    @Override
    public void createBitmap(Context context, int size) {
        Bitmap bmpFull;
        if(color == Colors.white){
            bmpFull = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_pawn);
        } else {
            bmpFull = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_pawn);
        }

        this.bmp = Bitmap.createScaledBitmap(bmpFull, size, size, false);
    }

}
