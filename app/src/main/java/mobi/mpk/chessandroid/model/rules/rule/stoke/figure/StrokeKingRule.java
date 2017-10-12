package mobi.mpk.chessandroid.model.rules.rule.stoke.figure;


import mobi.mpk.chessServerSpring.domain.Cell;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.figure.King;

public class StrokeKingRule implements StrokeFigureRule {

    @Override
    public boolean checkRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        if (!stroke.getFigure().equals(new King())) {
            return false;
        }

        if (from.getX() - to.getX() == 1) {

            if (from.getY() - to.getY() == 1) {
                return true; //down l
            } else if (from.getY() - to.getY() == -1) {
                return true; //up l
            } else if (from.getY() - to.getY() == 0) {
                return true; //left
            }

        } else if (from.getX() - to.getX() == -1) {

            if (from.getY() - to.getY() == 1) {
                return true; //down r
            } else if (from.getY() - to.getY() == -1) {
                return true; //up r
            } else if (from.getY() - to.getY() == 0) {
                return true; //right
            }

        } else if (from.getX() - to.getX() == 0) {

            if (from.getY() - to.getY() == 1) {
                return true; //down
            } else if (from.getY() - to.getY() == -1) {
                return true; //up
            }

        }

        return false;
    }

}
