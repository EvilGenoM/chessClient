package mobi.mpk.chessandroid.model.rules;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.exception.FigureNotFindException;
import mobi.mpk.chessandroid.model.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chessandroid.model.exception.rule.PossibleMoveException;
import mobi.mpk.chessandroid.model.exception.rule.WayFigureHaveObstaclesException;
import mobi.mpk.chessandroid.model.figure.Rook;
import mobi.mpk.chessandroid.type.Color;

public class ClassicInspectorRulesTest {

    private Board board;

    @Before
    public void before(){

        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.white));

            cell = new Cell('a', 8);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.black));

            cell = new Cell('h', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.white));


        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = PossibleMoveException.class)
    public void testA1A8() throws Exception {

        Stroke stroke = new Stroke("a1 a8");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.black);
    }

    @Test(expected = WayFigureHaveObstaclesException.class)
    public void testA1H1() throws Exception {

        Stroke stroke = new Stroke("a1 h1");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

        assert(false);
    }

    @Test(expected = FigureCanNotMoveException.class)
    public void testA1C3() throws Exception {

        Stroke stroke = new Stroke("a1 c3");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

    }

    @Test(expected = FigureNotFindException.class)
    public void testC3C4() throws Exception {

        Stroke stroke = new Stroke("c3 a4");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

    }

    @Test
    public void testA1A8true() throws Exception {

        Stroke stroke = new Stroke("a1 a8");
        stroke.findFigure(board);
        InspectorRules inspector = new ClassicInspectorRules();
        inspector.checkMoveRules(board, stroke, Color.white);

        assert(true);

    }




}
