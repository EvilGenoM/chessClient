package mobi.mpk.chessandroid.model.figure.factory;


import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.figure.King;
import mobi.mpk.chessandroid.type.Color;

public class FactoryKing extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new King(color);
    }

}
