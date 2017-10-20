package mobi.mpk.chessandroid.controller;

import java.util.Map;

import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.game.Game;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.GamePresenter;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.ResultType;

/**
 * Created by evgen on 10.10.17.
 */

public class GameController {

    private Game game;
    private GameData gameData;
    private GamePresenter gamePresenter;

    private String stroke;
    private boolean white = true;
    private Color color = Color.white;

    public GameController(GameData gameData, GamePresenter gamePresenter) {
        this.gameData = gameData;
        this.gamePresenter = gamePresenter;
    }

    public void setGame(Game game) {
        this.game = game;
        white = true;
        color = Color.white;
    }

    public Color getColor() {
        return color;
    }

    public boolean checkExistGame() {

        if (game == null) {
            return false;
        } else {
            return true;
        }

    }

    public boolean checkExistFigure(char x, int y) {

        return game.checkExistFigure(x, y);

    }

    public boolean checkExistFigure(String cordinate) {

        char x = cordinate.charAt(0);
        int y = Character.digit(cordinate.charAt(1), 10);

        return game.checkExistFigure(x, y);

    }

    public Map<String, Enum> getFigureData(char x, int y) {

        return game.getFigureData(x, y);

    }

    public void handleStroke(String coordinateCell) {

        char x = coordinateCell.charAt(0);
        int y = Integer.parseInt(String.valueOf(coordinateCell.charAt(1)));

        if (game.checkExistFigure(x, y, color)) {

            gamePresenter.update();

            stroke = coordinateCell;
            gamePresenter.setHighlightCell(coordinateCell);

        } else {

            stroke += " " + coordinateCell;
            move(stroke);

            stroke = "";

        }

    }

    private void move(String stroke) {

        if (white) {
            ResultType result = game.doStroke(new User("One"), stroke);
            if (result == ResultType.SUCCESS) {
                white = false;
                color = Color.black;
            }
            gameData.setResultGame(result);
        } else {
            ResultType result = game.doStroke(new User("Two"), stroke);
            if (result == ResultType.SUCCESS) {
                white = true;
                color = Color.white;
            }
            gameData.setResultGame(result);
        }

    }

    public Game getGame() {
        return game;
    }

    public void update() {

        gamePresenter.update();

    }
}
