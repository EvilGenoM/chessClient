package mobi.mpk.chessandroid.controller;

import java.util.Map;

import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.game.Game;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.type.ResultType;

/**
 * Created by evgen on 10.10.17.
 */

public class GameController {

    private Game game;
    private GameData gameData;
    private boolean white = true;

    public GameController(GameData gameData){
        this.gameData = gameData;
    }

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
            ResultType result = game.doStroke(new User("One"), stroke);
            if(result == ResultType.SUCCESS){
                gameData.setResultGame();
                white = false;
            }
        } else {
            ResultType result = game.doStroke(new User("Two"), stroke);
            if(result == ResultType.SUCCESS){
                gameData.setResultGame();
                white = true;
            }
        }

    }

    public boolean checkExistGame() {

        if(game == null){
            return false;
        } else {
            return true;
        }

    }
}
