package mobi.mpk.chessandroid.model.figure;


import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class King extends Figure {

    public King(Color color) {
        super(color);
        setFigureType(FigureType.KING);
    }

    public King() {

    }

}
