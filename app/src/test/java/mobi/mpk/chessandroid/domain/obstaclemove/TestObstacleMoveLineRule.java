package mobi.mpk.chessandroid.domain.obstaclemove;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.exception.CellCorrectException;
import mobi.mpk.chessandroid.domain.exception.FigureNotFindException;
import mobi.mpk.chessandroid.domain.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.domain.figure.Knight;
import mobi.mpk.chessandroid.domain.figure.Pawn;
import mobi.mpk.chessandroid.domain.figure.Queen;
import mobi.mpk.chessandroid.domain.figure.Rook;
import mobi.mpk.chessandroid.domain.rules.rule.obstacle.move.ObstacleMoveLineRule;
import mobi.mpk.chessandroid.domain.rules.rule.obstacle.move.ObstacleMoveRule;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class TestObstacleMoveLineRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {
        board = new Board();
        Cell cell = board.getCell('a',1);
        cell.setFigure(new Rook(Color.white));

        cell = board.getCell('a', 6);
        cell.setFigure(new Queen(Color.white));

        cell = board.getCell('g', 1);
        cell.setFigure(new Pawn(Color.black));

        cell = board.getCell('h',8);
        cell.setFigure(new Rook(Color.white));

        cell = board.getCell('h',1);
        cell.setFigure(new Rook(Color.white));

        cell = board.getCell('a',8);
        cell.setFigure(new Rook(Color.white));

        cell = board.getCell('e',4);
        cell.setFigure(new Knight(Color.white));
    }

    @Test
    public void testA1A5(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a5");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, true);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1A6(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a6");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1A7(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a7");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1G1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 g1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, true);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1H1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 h1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testH8H2(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("h8 h2");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, true);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testH8H1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("h8 h1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testH8C8(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("h8 c8");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, true);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testH8A1(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("h8 a1");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testG1G2(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("g1 g2");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testE4D6(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 d6");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testE4C3(){

        Stroke stroke = null;
        try {
            stroke = new Stroke("e4 c3");
            stroke.findFigure(board);

            ObstacleMoveRule rule = new ObstacleMoveLineRule();
            boolean result = rule.checkRule(stroke, board);

            assertEquals(result, false);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }

    }

}
