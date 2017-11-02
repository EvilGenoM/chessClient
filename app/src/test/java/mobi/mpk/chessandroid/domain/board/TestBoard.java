package mobi.mpk.chessandroid.domain.board;


import org.junit.Test;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.exception.CellCorrectException;

import static org.junit.Assert.assertEquals;

public class TestBoard {

    @Test
    public void testGetCellA1(){

        try {
            Board board = new Board();
            Cell cell = board.getCell('a', 1);

            assertEquals(cell, new Cell('a', 1));


        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetCellH8(){

        try {
            Board board = new Board();
            Cell cell = board.getCell('h', 8);

            assertEquals(cell, new Cell('h', 8));


        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetCellI9(){

        try {
            Board board = new Board();
            Cell cell = board.getCell('i', 9);

            assertEquals(cell, null);


        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }


}
