package mobi.mpk.chessandroid.controller;

import java.util.Map;

import mobi.mpk.chessandroid.model.game.Game;

/**
 * Created by evgen on 10.10.17.
 */

public class GameController {

    private Game game;

    public boolean checkExistFigure(char x, int y){

        return game.checkExistFigure(x, y);

    }

    public Map<String,Enum> getFigureData(char x, int y) {

        return game.getFigureData(x, y);

    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void moveFigure() {

        game.moveFigure();

    }
}
