package mobi.mpk.chessandroid.model.figure.factory;

import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public abstract class FactoryFigure {

    public abstract Figure factoryMethod(Color color);

}
