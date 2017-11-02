package mobi.mpk.chessandroid.domain.rules.rule;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.exception.CellCorrectException;
import mobi.mpk.chessandroid.domain.exception.FigureNotFindException;
import mobi.mpk.chessandroid.domain.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.domain.figure.Bishop;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeBishopRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class TestStrokeBishopRule {

    private Board board;

    @Before
    public void before() throws CellCorrectException {

        board = new Board();

        Cell cell = new Cell('a',1);
        cell = board.getCell(cell);
        cell.setFigure(new Bishop(Color.white));

        cell = new Cell('a',8);
        cell = board.getCell(cell);
        cell.setFigure(new Bishop(Color.white));

        cell = new Cell('h',8);
        cell = board.getCell(cell);
        cell.setFigure(new Bishop(Color.white));

        cell = new Cell('h',1);
        cell = board.getCell(cell);
        cell.setFigure(new Bishop(Color.white));

    }

    @Test
    public void testA1B2(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 b2");
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
    public void testA1H8(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 h8");
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
    public void testH8A1(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("h8 a1");
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
    public void testA8H1(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a8 h1");
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
    public void testA1A8(){

        StrokeFigureRule strokeFigureRule = new StrokeBishopRule();

        Stroke stroke = null;
        try {
            stroke = new Stroke("a1 a8");
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

}
