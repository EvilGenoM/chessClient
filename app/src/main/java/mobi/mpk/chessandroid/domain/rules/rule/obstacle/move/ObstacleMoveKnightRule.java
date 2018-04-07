package mobi.mpk.chessandroid.domain.rules.rule.obstacle.move;


import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.Knight;

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
