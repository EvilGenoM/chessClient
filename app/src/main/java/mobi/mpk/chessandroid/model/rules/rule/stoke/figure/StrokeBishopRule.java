package mobi.mpk.chessandroid.model.rules.rule.stoke.figure;

import mobi.mpk.chessServerSpring.domain.Cell;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.figure.Bishop;

public class StrokeBishopRule implements StrokeFigureRule {

    @Override
    public boolean checkRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        if (!stroke.getFigure().equals(new Bishop())) {
            return false;
        }

        boolean isStroke = true;

        if (Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY())) {

            if (from.getX() - to.getX() < 0 && from.getY() - to.getY() < 0) { //up right

                return isStroke;

            } else if (from.getX() - to.getX() > 0 && from.getY() - to.getY() < 0) { //up left

                return isStroke;

            } else if (from.getX() - to.getX() < 0 && from.getY() - to.getY() > 0) { // down right

                return isStroke;

            } else if (from.getX() - to.getX() > 0 && from.getY() - to.getY() > 0) { // down left

                return isStroke;

            }

        }

        isStroke = false;
        return isStroke;

    }

}
