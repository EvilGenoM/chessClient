package mobi.mpk.chessandroid.model.figure;


import mobi.mpk.chessServerSpring.domain.Color;

public class FactoryBishop extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Bishop(color);
    }

}
