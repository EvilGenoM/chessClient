package mobi.mpk.chessandroid.domain.game;


import org.junit.Before;
import org.junit.Test;

import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.type.ResultType;

import static org.junit.Assert.assertEquals;

public class ClassicGameTest {

    private Game game;
    private User playerWhite;
    private User playerBlack;

    @Before
    public void before(){

        playerWhite = new User("PlayerWhite");
        playerBlack = new User("PlayerBlack");

        game = new ClassicGame(playerWhite, playerBlack);

    }

    @Test
    public void testA2A4(){

        ResultType resultStroke = game.doStroke(playerWhite, "a2 a4");

        boolean success;

        if(resultStroke == ResultType.SUCCESS){
            success = true;
        } else {
            success = false;
        }

        assertEquals(success, true);

    }

    @Test
    public void testB2A3(){

        ResultType resultStroke = game.doStroke(playerWhite, "b2 a3");

        boolean success;

        if(resultStroke == ResultType.SUCCESS){
            success = true;
        } else {
            success = false;
        }

        assertEquals(success, false);
    }

    @Test
    public void testB2B4(){

        ResultType resultStroke = game.doStroke(playerWhite, "b2 b4");

        boolean success;

        if(resultStroke == ResultType.SUCCESS){
            success = true;
        } else {
            success = false;
        }

        assertEquals(success, true);
    }

    @Test
    public void testC2C3(){

        game.doStroke(playerWhite, "c2 c3");
        ResultType resultStroke = game.doStroke(playerWhite, "d2 d3");

        boolean success;

        if(resultStroke == ResultType.SUCCESS){
            success = true;
        } else {
            success = false;
        }

        assertEquals(success, false);
    }

    @Test
    public void testD7D5(){

        game.doStroke(playerWhite, "d2 d3");
        ResultType resultStroke = game.doStroke(playerBlack, "d7 d5");

        boolean success;

        if(resultStroke == ResultType.SUCCESS){
            success = true;
        } else {
            success = false;
        }

        assertEquals(success, true);
    }

}
