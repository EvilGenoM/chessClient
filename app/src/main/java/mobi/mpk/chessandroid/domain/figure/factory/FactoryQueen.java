package mobi.mpk.chessandroid.domain.figure.factory;

import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.Queen;
import mobi.mpk.chessandroid.type.Color;

public class FactoryQueen extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Queen(color);
    }

}
