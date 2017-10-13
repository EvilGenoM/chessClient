package mobi.mpk.chessandroid.model;


import java.util.Date;

import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.exception.FigureNotFindException;
import mobi.mpk.chessandroid.model.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.model.figure.Figure;

public class Stroke {


    private Cell from;
    private Cell to;
    private Figure figure;

    private Date time;

    public Stroke(Cell from, Cell to, Figure figure) {

        this.from = from;
        this.to = to;
        this.figure = figure;

    }


    public Stroke(String stroke) throws CellCorrectException, StrokeCorrectException {

        String[] coordCell = stroke.split(" ");

        if (coordCell.length != 2) {
            throw new StrokeCorrectException();
        }

        if (coordCell[0] != null && coordCell[1] != null) {
            this.from = createCell(coordCell[0]);
            this.to = createCell(coordCell[1]);
        }

        this.time = new Date();

    }

    private Cell createCell(String coordCell) throws CellCorrectException, StrokeCorrectException {

        if (coordCell.length() > 2) {
            throw new StrokeCorrectException();
        }

        char xCoordCell = coordCell.charAt(0);
        int yCoordCell = Character.getNumericValue(coordCell.charAt(1));

        return new Cell(xCoordCell, yCoordCell);

    }

    public void findFigure(Board board) throws FigureNotFindException {

        Cell from = board.getCell(this.from);
        Figure figure = from.getFigure();

        if (figure == null) {
            throw new FigureNotFindException();
        } else {
            this.figure = figure;
        }

    }

    public Cell getFrom() {
        return from;
    }

    public Cell getTo() {
        return to;
    }


    public Figure getFigure() {
        return figure;
    }
}
