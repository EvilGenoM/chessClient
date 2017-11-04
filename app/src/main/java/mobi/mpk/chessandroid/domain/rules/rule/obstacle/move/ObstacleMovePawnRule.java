package mobi.mpk.chessandroid.domain.rules.rule.obstacle.move;


import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.Pawn;

public class ObstacleMovePawnRule implements ObstacleMoveRule {

    @Override
    public boolean checkRule(Stroke stroke, Board board) {

        boolean isCheck = false;

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();
        to = board.getCell(to);

        Figure figure = stroke.getFigure();

        if (!figure.equals(new Pawn())) {
            return isCheck;
        }

        if (from.getX() - to.getX() == 0) {
            return checkVerticalWayFigure(from, to, figure, board);
        } else if (Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY())) {
            return checkDiagonalWayFigure(from, to, figure, board);
        } else {
            return isCheck;
        }

    }

    private boolean checkVerticalWayFigure(Cell from, Cell to, Figure figure, Board board) {

        char fromX = from.getX();
        int fromY = from.getY();

        int toY = to.getY();

        int changeY = (toY - fromY) / Math.abs(toY - fromY);

        while (fromY != toY) {

            fromY += changeY;

            Cell cell = board.getCell(fromX, fromY);

            if (fromY != toY && cell.getFigure() != null) {
                return false;
            }

        }

        return checkCellToLine(to.getFigure());

    }

    private boolean checkCellToLine(Figure figureTo) {

        if (figureTo == null) {
            return true;
        } else {
            return false;
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

        return checkCellToDiagonal(figure, to.getFigure());

    }

    private boolean checkCellToDiagonal(Figure figureFrom, Figure figureTo) {

        if (figureTo == null) {
            return false;
        } else if (figureFrom.getColor() != figureTo.getColor()) {
            return true;
        } else {
            return false;
        }

    }

}
