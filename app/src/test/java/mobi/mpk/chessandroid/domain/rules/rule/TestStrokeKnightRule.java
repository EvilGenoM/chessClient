package mobi.mpk.chessandroid.domain.rules.rule;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.exception.CellCorrectException;
import mobi.mpk.chessandroid.domain.exception.FigureNotFindException;
import mobi.mpk.chessandroid.domain.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.domain.figure.Knight;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeKnightRule;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class TestStrokeKnightRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {

        board = new Board();

        Cell cell = new Cell('a',1);
        cell = board.getCell(cell);
        cell.setFigure(new Knight(Color.white));

        cell = new Cell('d',5);
        cell = board.getCell(cell);
        cell.setFigure(new Knight(Color.white));

    }

    @Test
    public void testA1A2(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a2");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, false);

    }

    @Test
    public void testD5E3(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 e3");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5C3(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 c3");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5F4(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 f4");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5B4(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 b4");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5F6(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 f6");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5B6(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 b6");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5C7(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 c7");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

    @Test
    public void testD5E7(){

        StrokeFigureRule strokeFigureRule = new StrokeKnightRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("d5 e7");
            stroke.findFigure(board);
        } catch (CellCorrectException e) {
            e.printStackTrace();
        } catch (StrokeCorrectException e) {
            e.printStackTrace();
        } catch (FigureNotFindException e) {
            e.printStackTrace();
        }
        boolean resultStroke = strokeFigureRule.checkRule(stroke);

        assertEquals(resultStroke, true);

    }

}
