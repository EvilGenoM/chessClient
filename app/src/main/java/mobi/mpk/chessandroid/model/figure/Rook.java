package mobi.mpk.chessandroid.model.figure;


import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class Rook extends Figure {

    public Rook(Color color) {
        super(color);
        setFigureType(FigureType.ROOK);
    }

    public Rook() {

    }

}
