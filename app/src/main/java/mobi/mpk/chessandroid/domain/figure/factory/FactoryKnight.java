package mobi.mpk.chessandroid.domain.figure.factory;


import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.Knight;
import mobi.mpk.chessandroid.type.Color;

public class FactoryKnight extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Knight(color);
    }

}
