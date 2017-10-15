package mobi.mpk.chessandroid.model.rules.endgame;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.figure.King;
import mobi.mpk.chessandroid.model.rules.rule.end.game.ClassicEndGameRule;
import mobi.mpk.chessandroid.model.rules.rule.end.game.EndGameRule;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class ClassicEndGameTest {

    private Board boardKingBlack;
    private Board boardKingWhite;
    private Board board2Kings;

    @Before
    public void before() throws CellCorrectException {

        board2Kings = new Board();

        Cell cell = new Cell('a', 1);
        cell = board2Kings.getCell(cell);
        cell.setFigure(new King(Color.white));
        cell = new Cell('a', 2);
        cell = board2Kings.getCell(cell);
        cell.setFigure(new King(Color.black));

        boardKingBlack = new Board();

        cell = new Cell('a', 1);
        cell = boardKingBlack.getCell(cell);
        cell.setFigure(new King(Color.black));

        boardKingWhite = new Board();

        cell = new Cell('a', 1);
        cell = boardKingWhite.getCell(cell);
        cell.setFigure(new King(Color.white));
    }

    @Test
    public void testBoardKingWhite(){

        EndGameRule rule = new ClassicEndGameRule();
        boolean result = rule.checkRule(boardKingWhite);

        assert(result);

    }

    @Test
    public void testBoardKingBlack(){

        EndGameRule rule = new ClassicEndGameRule();
        boolean result = rule.checkRule(boardKingBlack);

        assert(result);

    }

    @Test
    public void testBoard2King(){

        EndGameRule rule = new ClassicEndGameRule();
        boolean result = rule.checkRule(board2Kings);

        assertEquals(result, false);

    }

    @Test
    public void testGetColorWinnerBlack(){

        EndGameRule rule = new ClassicEndGameRule();
        rule.checkRule(boardKingBlack);
        Color color = rule.getColorWinner();

        assertEquals(color, Color.black);

    }

    @Test
    public void testGetColorWinnerWhite(){

        EndGameRule rule = new ClassicEndGameRule();
        rule.checkRule(boardKingWhite);
        Color color = rule.getColorWinner();

        assertEquals(color, Color.white);

    }

}
