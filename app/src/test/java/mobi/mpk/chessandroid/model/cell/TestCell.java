package mobi.mpk.chessandroid.model.cell;


import org.junit.Test;

import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;

import static org.junit.Assert.assertEquals;

public class TestCell {

    @Test
    public void testA1(){

        try {
            Cell cell1 = new Cell(0,0);
            Cell cell2 = new Cell('a', 1);

            assertEquals(cell1, cell2);
        } catch (CellCorrectException ex){

        }

    }

    @Test
    public void testA1Null(){

        try {
            Cell cell1 = new Cell(0,0);
            Cell cell2 = new Cell('a', 1, null);

            assertEquals(cell1, cell2);
        } catch (CellCorrectException ex){

        }

    }

    @Test(expected = CellCorrectException.class)
    public void testX8Y0() throws CellCorrectException {
            Cell cell1 = new Cell(8,0);
    }

    @Test(expected = CellCorrectException.class)
    public void testI1() throws CellCorrectException {
        Cell cell1 = new Cell('i',1);
    }

    @Test(expected = CellCorrectException.class)
    public void testI9() throws CellCorrectException{
        Cell cell1 = new Cell('i',9);
    }

}
