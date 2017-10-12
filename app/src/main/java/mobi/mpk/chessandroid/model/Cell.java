package mobi.mpk.chessandroid.model;


import mobi.mpk.chessServerSpring.domain.exception.CellCorrectException;
import mobi.mpk.chessServerSpring.domain.figure.Figure;

public class Cell {

    private char x;
    private int y;
    private Figure figure = null;

    public Cell(char x, int y, Figure figure) throws CellCorrectException {

        addXY(x, y);

        this.figure = figure;
    }

    public Cell(char x, int y) throws CellCorrectException {
        this(x, y, null);
    }

    public Cell(int x, int y) throws CellCorrectException {

        char symbolX = 'a';
        for (int i = 0; i < x; i++) {
            ++symbolX;
        }

        int numberY = y + 1;

        addXY(symbolX, numberY);
        this.figure = null;

    }

    private void addXY(char x, int y) throws CellCorrectException {

        if (x >= 'a' && x <= 'h') {
            this.x = x;
        } else throw new CellCorrectException();

        if (y >= 1) {
            this.y = y;
        } else throw new CellCorrectException();

    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return this.figure;
    }

    public int getIntX() {

        char symbol = 'a';
        int number = 1;
        while (this.x != symbol) {
            symbol++;
            number++;
        }

        return number;
    }

    public char getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        Cell cell = (Cell) o;
        if (this != null && cell != null && this.x == cell.getX() && this.y == cell.getY()) {
            return true;
        } else {
            return false;
        }

    }

}
