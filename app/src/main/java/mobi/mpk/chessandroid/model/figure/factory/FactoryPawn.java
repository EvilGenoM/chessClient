package mobi.mpk.chessandroid.model.figure.factory;

import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.figure.Pawn;
import mobi.mpk.chessandroid.type.Color;

public class FactoryPawn extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Pawn(color);
    }

}
