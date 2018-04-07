package mobi.mpk.chessandroid.domain.rules.possiblemove;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.exception.CellCorrectException;
import mobi.mpk.chessandroid.domain.exception.FigureNotFindException;
import mobi.mpk.chessandroid.domain.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.domain.figure.Pawn;
import mobi.mpk.chessandroid.domain.rules.rule.possiblemove.ClassicPossibleMoveRule;
import mobi.mpk.chessandroid.domain.rules.rule.possiblemove.PossibleMoveRule;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class ClassicPossibleMoveTest {

    private Board board;

    @Before
    public void before(){

        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Pawn(Color.black));

            cell = new Cell('a', 2);
            cell = board.getCell(cell);

            cell.setFigure(new Pawn(Color.white));
        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBlackBlack(){

        try {
            Stroke stroke = new Stroke("a1 a2");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.black, stroke);
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
    public void testBlackWhite(){

        try {
            Stroke stroke = new Stroke("a1 a2");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.white, stroke);
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
    public void testWhiteWhite(){

        try {
            Stroke stroke = new Stroke("a2 a3");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.white, stroke);
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
    public void testWhiteBlack(){

        try {
            Stroke stroke = new Stroke("a2 a3");
            stroke.findFigure(board);

            PossibleMoveRule rule = new ClassicPossibleMoveRule();

            boolean result = rule.checkPossibleMove(Color.black, stroke);
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
