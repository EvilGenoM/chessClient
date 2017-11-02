package mobi.mpk.chessandroid.domain.figure.factory;

import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.Pawn;
import mobi.mpk.chessandroid.type.Color;

public class FactoryPawn extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Pawn(color);
    }

}
