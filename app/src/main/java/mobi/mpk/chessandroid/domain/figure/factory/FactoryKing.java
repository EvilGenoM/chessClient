package mobi.mpk.chessandroid.domain.figure.factory;


import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.King;
import mobi.mpk.chessandroid.type.Color;

public class FactoryKing extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new King(color);
    }

}
