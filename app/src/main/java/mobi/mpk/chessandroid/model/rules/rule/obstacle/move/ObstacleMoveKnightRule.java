package mobi.mpk.chessandroid.model.rules.rule.obstacle.move;


import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.figure.Knight;

public class ObstacleMoveKnightRule implements ObstacleMoveRule {

    @Override
    public boolean checkRule(Stroke stroke, Board board) {

        Cell to = stroke.getTo();
        to = board.getCell(to);

        Figure figure = stroke.getFigure();

        if (!figure.equals(new Knight())) {
            return false;
        }

        if (to.getFigure() == null) {
            return true;
        } else if (to.getFigure().getColor() != figure.getColor()) {
            return true;
        } else {
            return false;
        }

    }

}
