package mobi.mpk.chessandroid.view.figure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import mobi.mpk.chessandroid.view.CellView;
import mobi.mpk.chessandroid.view.Colors;
import mobi.mpk.chessandroid.view.GameView;

/**
 * Created by evgen on 04.10.17.
 */

public abstract class FigureView {

    protected int adressBitmap;
    protected Colors color;

    public void onDraw(GameView gameView, int x, int y, int size){

        gameView.onDrawFigure(adressBitmap, x, y, size);

    }

}
