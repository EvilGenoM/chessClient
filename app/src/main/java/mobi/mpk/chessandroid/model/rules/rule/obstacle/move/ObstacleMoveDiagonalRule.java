package mobi.mpk.chessandroid.model.rules.rule.obstacle.move;


import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Cell;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.figure.Figure;
import mobi.mpk.chessServerSpring.domain.figure.Knight;
import mobi.mpk.chessServerSpring.domain.figure.Pawn;

public class ObstacleMoveDiagonalRule implements ObstacleMoveRule {

    @Override
    public boolean checkRule(Stroke stroke, Board board) {

        boolean isCheck = false;

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();
        to = board.getCell(to);

        Figure figure = stroke.getFigure();

        if (figure.equals(new Pawn()) || figure.equals(new Knight())) {
            return isCheck;
        }

        if (Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY())) {

            return checkDiagonalWayFigure(from, to, figure, board);

        } else {

            return isCheck;

        }

    }

    private boolean checkDiagonalWayFigure(Cell from, Cell to, Figure figure, Board board) {

        char fromX = from.getX();
        int fromY = from.getY();

        char toX = to.getX();
        int toY = to.getY();

        int changeX = (toX - fromX) / Math.abs(toX - fromX);
        int changeY = (toY - fromY) / Math.abs(toY - fromY);

        while (fromX != toX) {

            fromX += changeX;
            fromY += changeY;

            Cell cell = board.getCell(fromX, fromY);

            if (fromY != toY && cell.getFigure() != null) {
                return false;
            }

        }

        return checkCellTo(figure, to.getFigure());

    }

    private boolean checkCellTo(Figure figureFrom, Figure figureTo) {

        if (figureTo == null) {
            return true;
        } else if (figureTo.getColor() != figureFrom.getColor()) {
            return true;
        } else {
            return false;
        }

    }

}
