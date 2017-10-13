package mobi.mpk.chessandroid.model.figure.factory;

import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.figure.Rook;
import mobi.mpk.chessandroid.type.Color;

public class FactoryRook extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Rook(color);
    }

}
