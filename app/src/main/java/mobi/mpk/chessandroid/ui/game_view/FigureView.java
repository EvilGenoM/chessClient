package mobi.mpk.chessandroid.ui.game_view;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;
import mobi.mpk.chessandroid.ui.Settings;


public class FigureView {

    private int x;
    private int y;
    private int size;

    private Color color;

    private FigureType figureType;

    @Inject
    Drawer drawer;
    @Inject
    Settings settings;

    public FigureView(FigureType figureType, Color color, int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.figureType = figureType;
        this.color = color;
        App.getComponent().inject(this);
    }

    public void setLocation(int x, int y, int size){

        this.x = x;
        this.y = y;
        this.size = size;

    }


    public void onDraw() {

        if (figureType == FigureType.KING) {
            if (color == Color.white) {
                drawer.drawBitmap(settings.getWhiteKing(), x, y, size);
            } else {
                drawer.drawBitmap(settings.getBlackKing(), x, y, size);
            }
        } else if (figureType == FigureType.QUEEN) {
            if (color == Color.white) {
                drawer.drawBitmap(settings.getWhiteQueen(), x, y, size);
            } else {
                drawer.drawBitmap(settings.getBlackQueen(), x, y, size);
            }
        } else if (figureType == FigureType.BISHOP) {
            if (color == Color.white) {
                drawer.drawBitmap(settings.getWhiteBishop(), x, y, size);
            } else {
                drawer.drawBitmap(settings.getBlackBishop(), x, y, size);
            }
        } else if (figureType == FigureType.KNIGHT) {
            if (color == Color.white) {
                drawer.drawBitmap(settings.getWhiteKnight(), x, y, size);
            } else {
                drawer.drawBitmap(settings.getBlackKnight(), x, y, size);
            }
        } else if (figureType == FigureType.ROOK) {
            if (color == Color.white) {
                drawer.drawBitmap(settings.getWhiteRook(), x, y, size);
            } else {
                drawer.drawBitmap(settings.getBlackRook(), x, y, size);
            }
        } else {
            if (color == Color.white) {
                drawer.drawBitmap(settings.getWhitePawn(), x, y, size);
            } else {
                drawer.drawBitmap(settings.getBlackPawn(), x, y, size);
            }
        }

    }

    public Color getColor() {
        return color;
    }
}
