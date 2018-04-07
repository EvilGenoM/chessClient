package mobi.mpk.chessandroid.domain.rules.rule.order.figure;


import java.util.LinkedList;
import java.util.List;

import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.factory.FactoryBishop;
import mobi.mpk.chessandroid.domain.figure.factory.FactoryFigure;
import mobi.mpk.chessandroid.domain.figure.factory.FactoryKing;
import mobi.mpk.chessandroid.domain.figure.factory.FactoryKnight;
import mobi.mpk.chessandroid.domain.figure.factory.FactoryPawn;
import mobi.mpk.chessandroid.domain.figure.factory.FactoryQueen;
import mobi.mpk.chessandroid.domain.figure.factory.FactoryRook;
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
