package mobi.mpk.chessandroid.domain.rules.rule.possiblemove;


import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public class ClassicPossibleMoveRule implements PossibleMoveRule {

    @Override
    public boolean checkPossibleMove(Color color, Stroke stroke) {

        Figure figure = stroke.getFigure();
        if (figure.getColor() == color) {
            return true;
        } else {
            return false;
        }

    }
}
