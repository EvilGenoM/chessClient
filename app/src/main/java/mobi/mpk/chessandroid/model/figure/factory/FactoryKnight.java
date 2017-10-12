package mobi.mpk.chessandroid.model.figure.factory;


import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.figure.Knight;
import mobi.mpk.chessandroid.type.Color;

public class FactoryKnight extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Knight(color);
    }

}
