package mobi.mpk.chessandroid.model.figure;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.exception.FigureNotFindException;
import mobi.mpk.chessandroid.model.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class TestStrokeFindFigure {

    private Board board;

    @Before
    public void before(){
        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Pawn(Color.white));
        } catch (CellCorrectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExistFigure(){

        try {
            Stroke stroke = new Stroke("a1 a2");
            stroke.findFigure(board);

            String figureName = stroke.getFigure().getClass().getSimpleName();

            assertEquals(figureName, "Pawn");

        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = FigureNotFindException.class)
    public void testNullFigure() throws StrokeCorrectException, CellCorrectException, FigureNotFindException {

        Stroke stroke = new Stroke("a2 a3");
        stroke.findFigure(board);

    }

}
