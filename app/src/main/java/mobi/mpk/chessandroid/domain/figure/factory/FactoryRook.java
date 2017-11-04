package mobi.mpk.chessandroid.domain.figure.factory;

import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.Rook;
import mobi.mpk.chessandroid.type.Color;

public class FactoryRook extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Rook(color);
    }

}
