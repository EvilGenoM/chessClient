package mobi.mpk.chessandroid.model.figure;


import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class Queen extends Figure {

    public Queen(Color color) {
        super(color);
        setFigureType(FigureType.QUEEN);
    }

    public Queen() {

    }

}
