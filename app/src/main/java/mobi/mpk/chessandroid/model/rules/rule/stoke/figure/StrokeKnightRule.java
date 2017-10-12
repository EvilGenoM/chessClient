package mobi.mpk.chessandroid.model.rules.rule.stoke.figure;


import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.figure.Knight;

public class StrokeKnightRule implements StrokeFigureRule {

    @Override
    public boolean checkRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        if (!stroke.getFigure().equals(new Knight())) {
            return false;
        }

        if (from.getX() - to.getX() == 1) {

            if (from.getY() - to.getY() == 2) {
                return true;
            } else if (from.getY() - to.getY() == -2) {
                return true;
            }

        } else if (from.getX() - to.getX() == -1) {

            if (from.getY() - to.getY() == 2) {
                return true;
            } else if (from.getY() - to.getY() == -2) {
                return true;
            }

        } else if (from.getY() - to.getY() == 1) {

            if (from.getX() - to.getX() == 2) {
                return true;
            } else if (from.getX() - to.getX() == -2) {
                return true;
            }

        } else if (from.getY() - to.getY() == -1) {

            if (from.getX() - to.getX() == 2) {
                return true;
            } else if (from.getX() - to.getX() == -2) {
                return true;
            }

        }

        return false;
    }

}
