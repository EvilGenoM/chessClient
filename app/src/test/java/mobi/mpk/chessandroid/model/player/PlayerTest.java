package mobi.mpk.chessandroid.model.player;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Player;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.figure.Rook;
import mobi.mpk.chessandroid.model.rules.ClassicInspectorRules;
import mobi.mpk.chessandroid.model.rules.InspectorRules;
import mobi.mpk.chessandroid.type.Color;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Board board;

    @Before
    public void before(){

        try {
            board = new Board();

            Cell cell = new Cell('a', 1);
            cell = board.getCell(cell);

            cell.setFigure(new Rook(Color.white));
        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testA1A3() throws Exception {

        User user = new User("Player");

        Player player = new Player(user);
        player.setColorFigures(Color.white);

        InspectorRules inspector = new ClassicInspectorRules();

        Stroke stroke = new Stroke("a1 a3");
        stroke.findFigure(board);

        player.move(stroke, board, inspector);

        Cell cell = new Cell('a', 1);
        cell = board.getCell(cell);
        assertEquals(cell.getFigure(), null);

        cell = new Cell('a', 3);
        cell = board.getCell(cell);
        assertEquals(cell.getFigure(), new Rook());



    }

}