package mobi.mpk.chessandroid.model.figure;


import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class Bishop extends Figure {

    public Bishop(Color color) {
        super(color);
        setFigureType(FigureType.BISHOP);
    }

    public Bishop() {

    }

}
