package mobi.mpk.chessandroid.view.figure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.view.Colors;

/**
 * Created by evgen on 04.10.17.
 */

public class RookView extends FigureView{

    public RookView(Colors color){

        this.color = color;

        if(color == Colors.white){
            this.adressBitmap = R.drawable.white_rook;
        } else {
            this.adressBitmap = R.drawable.black_rook;
        }

    }

}
