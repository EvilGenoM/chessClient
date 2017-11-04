package mobi.mpk.chessandroid.domain.figure;


import org.junit.Test;

import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.exception.CellCorrectException;
import mobi.mpk.chessandroid.domain.exception.StrokeCorrectException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestStroke {

    @Test
    public void testA1A2(){

        try {
            Stroke stroke = new Stroke("a1 a2");
            Cell cell1 = new Cell('a', 1);
            Cell cell2 = new Cell('a', 2);

            assertEquals(stroke.getFrom(), cell1);
            assertEquals(stroke.getTo(), cell2);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1A2Mockito() throws CellCorrectException {

            Stroke strokeMockito = mock(Stroke.class);
            Cell cell1Mockito = new Cell('a', 1);

            when(strokeMockito.getFrom()).thenReturn(new Cell('a', 1));

            assertEquals(strokeMockito.getFrom(), cell1Mockito);

    }

    @Test
    public void testA1H82(){

        try {
            Stroke stroke = new Stroke("a1 h8");
            Cell cell1 = new Cell('a', 1);
            Cell cell2 = new Cell('h', 8);

            assertEquals(stroke.getFrom(), cell1);
            assertEquals(stroke.getTo(), cell2);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = StrokeCorrectException.class)
    public void testA1A2A3() throws StrokeCorrectException, CellCorrectException {

        Stroke stroke = new Stroke("a1 a2 a3");

    }

    @Test(expected = StrokeCorrectException.class)
    public void testA1BA2B() throws StrokeCorrectException, CellCorrectException {

        Stroke stroke = new Stroke("a1b a2b");

    }

}
