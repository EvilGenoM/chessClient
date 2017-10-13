package mobi.mpk.chessandroid.model.rules.rule.possiblemove;


import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.figure.Figure;
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
