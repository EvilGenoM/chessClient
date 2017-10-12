package mobi.mpk.chessandroid.model.rules.rule.possiblemove;


import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.figure.Figure;

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
