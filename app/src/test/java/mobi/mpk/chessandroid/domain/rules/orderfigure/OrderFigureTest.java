package mobi.mpk.chessandroid.domain.rules.orderfigure;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.exception.CellCorrectException;
import mobi.mpk.chessandroid.domain.figure.Bishop;
import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.figure.King;
import mobi.mpk.chessandroid.domain.figure.Knight;
import mobi.mpk.chessandroid.domain.figure.Pawn;
import mobi.mpk.chessandroid.domain.figure.Queen;
import mobi.mpk.chessandroid.domain.figure.Rook;
import mobi.mpk.chessandroid.domain.rules.rule.order.figure.ClassicOrderFigureRule;
import mobi.mpk.chessandroid.domain.rules.rule.order.figure.OrderFigureRule;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class OrderFigureTest {

    private Board board;

    @Before
    public void before(){

        try {
            board = new Board();

            OrderFigureRule rule = new ClassicOrderFigureRule();
            List<Figure> listFigure = rule.orderFigure(Color.white);

            Cell[][] cells = board.getMassiveCell();
            int x = 0;
            int y = 0;
            for(Figure figure : listFigure){

                cells[x][y].setFigure(figure);
                x++;

                if(x == 8){
                    y++;
                    x = 0;
                }
            }

        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1(){

        Cell cell = board.getCell('a', 1);

        assertEquals(cell.getFigure(), new Rook());

    }

    @Test
    public void testB1(){

        Cell cell = board.getCell('b', 1);

        assertEquals(cell.getFigure(), new Knight());

    }

    @Test
    public void testC1(){

        Cell cell = board.getCell('c', 1);

        assertEquals(cell.getFigure(), new Bishop());

    }

    @Test
    public void testD1(){

        Cell cell = board.getCell('d', 1);

        assertEquals(cell.getFigure(), new Queen());

    }

    @Test
    public void testE1(){

        Cell cell = board.getCell('e', 1);

        assertEquals(cell.getFigure(), new King());

    }

    @Test
    public void testF1(){

        Cell cell = board.getCell('f', 1);

        assertEquals(cell.getFigure(), new Bishop());

    }

    @Test
    public void testG1(){

        Cell cell = board.getCell('g', 1);

        assertEquals(cell.getFigure(), new Knight());

    }

    @Test
    public void testH1(){

        Cell cell = board.getCell('h', 1);

        assertEquals(cell.getFigure(), new Rook());

    }

    @Test
    public void testA2(){

        Cell cell = board.getCell('a', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

    @Test
    public void testB2(){

        Cell cell = board.getCell('b', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

    @Test
    public void testC2(){

        Cell cell = board.getCell('c', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

    @Test
    public void testD2(){

        Cell cell = board.getCell('d', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

    @Test
    public void testE2(){

        Cell cell = board.getCell('e', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

    @Test
    public void testF2(){

        Cell cell = board.getCell('f', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

    @Test
    public void testG2(){

        Cell cell = board.getCell('g', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

    @Test
    public void testH2(){

        Cell cell = board.getCell('h', 2);

        assertEquals(cell.getFigure(), new Pawn());

    }

}
