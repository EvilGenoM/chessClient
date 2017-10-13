package mobi.mpk.chessandroid.controller;

import java.util.Map;

import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.game.Game;

/**
 * Created by evgen on 10.10.17.
 */

public class GameController {

    private Game game;
    private boolean white = true;

    public boolean checkExistFigure(char x, int y){

        return game.checkExistFigure(x, y);

    }

    public Map<String,Enum> getFigureData(char x, int y) {

        return game.getFigureData(x, y);

    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void move(String stroke) {

        if(white){
            game.doStroke(new User("One"), stroke);
            white = false;
        } else {
            game.doStroke(new User("Two"), stroke);
            white = true;
        }

    }

}
