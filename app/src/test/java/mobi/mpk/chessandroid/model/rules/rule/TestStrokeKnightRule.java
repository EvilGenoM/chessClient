package mobi.mpk.chessandroid.model.rules.rule;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.exception.FigureNotFindException;
import mobi.mpk.chessandroid.model.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.model.figure.Knight;
import mobi.mpk.chessandroid.model.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chessandroid.model.rules.rule.stoke.figure.StrokeKnightRule;
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
