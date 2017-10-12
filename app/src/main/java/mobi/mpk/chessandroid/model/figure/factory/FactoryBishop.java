package mobi.mpk.chessandroid.model.figure.factory;


import mobi.mpk.chessandroid.model.figure.Bishop;
import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public class FactoryBishop extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Bishop(color);
    }

}
