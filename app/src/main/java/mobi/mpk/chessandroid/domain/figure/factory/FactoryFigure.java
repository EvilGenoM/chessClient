package mobi.mpk.chessandroid.domain.figure.factory;

import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public abstract class FactoryFigure {

    public abstract Figure factoryMethod(Color color);

}
