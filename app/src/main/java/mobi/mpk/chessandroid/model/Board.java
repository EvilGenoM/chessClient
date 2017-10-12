package mobi.mpk.chessandroid.model;


import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.figure.Figure;

public class Board {

    private Cell[][] cells;

    public Board() throws CellCorrectException {

        cells = new Cell[8][8];

        for (int x = 0; x < 8; x++) {

            for (int y = 0; y < 8; y++) {
                cells[x][y] = new Cell(x, y);
            }

        }

    }

    public Cell[][] getMassiveCell() {
        return cells;
    }

    public Cell getCell(Cell cell) {

        int x = cell.getIntX() - 1;
        int y = cell.getY() - 1;

        return this.cells[x][y];
    }

    public Cell getCell(char letter, int number) {


        if (letter < 'a' || letter > 'h') {
            return null;
        }

        if (number < 1 || number > 8) {
            return null;
        }

        int x = (letter - 'a');
        int y = number - 1;


        return this.cells[x][y];
    }

    public boolean existFigure(Figure figure) {

        for (int y = 0; y < 8; y++) {

            for (int x = 0; x < 8; x++) {

                if (cells[x][y].getFigure() != null && cells[x][y].getFigure().equals(figure)) {

                    if (cells[x][y].getFigure().getColor() == figure.getColor()) {
                        return true;
                    }

                }

            }

        }

        return false;

    }


}
