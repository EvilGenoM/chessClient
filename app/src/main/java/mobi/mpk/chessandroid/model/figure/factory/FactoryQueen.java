package mobi.mpk.chessandroid.model.figure.factory;

import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.figure.Queen;
import mobi.mpk.chessandroid.type.Color;

public class FactoryQueen extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Queen(color);
    }

}
