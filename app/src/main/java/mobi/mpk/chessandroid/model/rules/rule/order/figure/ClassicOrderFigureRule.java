package mobi.mpk.chessandroid.model.rules.rule.order.figure;


import java.util.LinkedList;
import java.util.List;

import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.figure.factory.FactoryBishop;
import mobi.mpk.chessandroid.model.figure.factory.FactoryFigure;
import mobi.mpk.chessandroid.model.figure.factory.FactoryKing;
import mobi.mpk.chessandroid.model.figure.factory.FactoryKnight;
import mobi.mpk.chessandroid.model.figure.factory.FactoryPawn;
import mobi.mpk.chessandroid.model.figure.factory.FactoryQueen;
import mobi.mpk.chessandroid.model.figure.factory.FactoryRook;
import mobi.mpk.chessandroid.type.Color;

public class ClassicOrderFigureRule implements OrderFigureRule {

    @Override
    public List<Figure> orderFigure(Color color) {

        List<FactoryFigure> creators = new LinkedList<FactoryFigure>();
        List<Figure> orderFigures = new LinkedList<Figure>();

        creators.add(new FactoryRook());
        creators.add(new FactoryKnight());
        creators.add(new FactoryBishop());
        creators.add(new FactoryQueen());
        creators.add(new FactoryKing());
        creators.add(new FactoryBishop());
        creators.add(new FactoryKnight());
        creators.add(new FactoryRook());

        for (int i = 0; i < 8; i++) {

            creators.add(new FactoryPawn());

        }


        for (FactoryFigure creator : creators) {
            orderFigures.add(creator.factoryMethod(color));
        }


        return orderFigures;

    }

}
