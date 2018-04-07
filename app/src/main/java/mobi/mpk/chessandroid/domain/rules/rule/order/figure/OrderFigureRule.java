package mobi.mpk.chessandroid.domain.rules.rule.order.figure;

import java.util.List;

import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public interface OrderFigureRule {

    List<Figure> orderFigure(Color color);

}
