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

        if(color == Colors.white){
            this.adressBitmap = R.drawable.white_pawn;
        } else {
            this.adressBitmap = R.drawable.black_pawn;
        }


    }

}
