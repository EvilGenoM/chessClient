package mobi.mpk.chessandroid.model.rules.rule.stoke.figure;


import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.figure.Rook;

public class StrokeRookRule implements StrokeFigureRule {

    @Override
    public boolean checkRule(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        if (!stroke.getFigure().equals(new Rook())) {
            return false;
        }


        boolean isStroke = true;

        if (from.getX() - to.getX() > 0 && from.getY() == to.getY()) { // left

            return isStroke;

        } else if (from.getX() - to.getX() < 0 && from.getY() == to.getY()) { // right

            return isStroke;

        } else if (from.getY() - to.getY() > 0 && from.getX() == to.getX()) { // down

            return isStroke;

        } else if (from.getY() - to.getY() < 0 && from.getX() == to.getX()) { // up

            return isStroke;

        }

        isStroke = false;
        return isStroke;

    }

}
