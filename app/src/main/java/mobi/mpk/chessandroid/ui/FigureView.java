package mobi.mpk.chessandroid.ui;

import javax.inject.Inject;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

/**
 * Created by evgen on 10.10.17.
 */

public class FigureView {

    private int x;
    private int y;
    private int size;

    private Color color;

    private FigureType figureType;

    @Inject
    private Drawer drawer;

    public FigureView(int x, int y, int size, FigureType figureType, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.figureType = figureType;
        this.color = color;
    }

    public void onDraw() {

        if(figureType == FigureType.KING){
            if(color == Color.white){
                drawer.drawBitmap(R.drawable.white_king, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.white_king, x, y, size);
            }
        } else if(figureType == FigureType.QUEEN) {
            if(color == Color.white){
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            }
        } else if(figureType == FigureType.BISHOP) {
            if(color == Color.white){
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            }
        } else if(figureType == FigureType.KNIGHT) {
            if(color == Color.white){
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            }
        } else if(figureType == FigureType.ROOK) {
            if(color == Color.white){
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            }
        } else {
            if(color == Color.white){
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            }
        }

    }

}
