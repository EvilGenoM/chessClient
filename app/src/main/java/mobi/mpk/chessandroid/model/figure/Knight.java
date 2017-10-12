package mobi.mpk.chessandroid.model.figure;


import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class Knight extends Figure {

    public Knight(Color color) {
        super(color);
        setFigureType(FigureType.KNIGHT);
    }

    public Knight() {

    }

}
