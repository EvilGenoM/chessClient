package mobi.mpk.chessandroid.model.figure;

import mobi.mpk.chessServerSpring.domain.Color;

public class FactoryPawn extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Pawn(color);
    }

}
