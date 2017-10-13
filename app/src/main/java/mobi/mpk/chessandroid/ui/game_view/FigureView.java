package mobi.mpk.chessandroid.ui.game_view;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;


public class FigureView {

    private int x;
    private int y;
    private int size;

    private Color color;

    private FigureType figureType;

    @Inject
    Drawer drawer;

    public FigureView(int x, int y, int size, FigureType figureType, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.figureType = figureType;
        this.color = color;
        App.getComponent().inject(this);
    }

    public void onDraw() {

        if (figureType == FigureType.KING) {
            if (color == Color.white) {
                drawer.drawBitmap(R.drawable.white_king, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.black_king, x, y, size);
            }
        } else if (figureType == FigureType.QUEEN) {
            if (color == Color.white) {
                drawer.drawBitmap(R.drawable.white_queen, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.black_queen, x, y, size);
            }
        } else if (figureType == FigureType.BISHOP) {
            if (color == Color.white) {
                drawer.drawBitmap(R.drawable.white_bishop, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.black_bishop, x, y, size);
            }
        } else if (figureType == FigureType.KNIGHT) {
            if (color == Color.white) {
                drawer.drawBitmap(R.drawable.white_knight, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.black_knight, x, y, size);
            }
        } else if (figureType == FigureType.ROOK) {
            if (color == Color.white) {
                drawer.drawBitmap(R.drawable.white_rook, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.black_rook, x, y, size);
            }
        } else {
            if (color == Color.white) {
                drawer.drawBitmap(R.drawable.white_pawn, x, y, size);
            } else {
                drawer.drawBitmap(R.drawable.black_pawn, x, y, size);
            }
        }

    }

    public Color getColor() {
        return color;
    }
}
