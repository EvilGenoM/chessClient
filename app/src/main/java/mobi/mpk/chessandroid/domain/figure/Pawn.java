package mobi.mpk.chessandroid.domain.figure;


import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class Pawn extends Figure {

    public Pawn(Color color) {
        super(color);
        setFigureType(FigureType.PAWN);
    }

    public Pawn() {

    }
}
