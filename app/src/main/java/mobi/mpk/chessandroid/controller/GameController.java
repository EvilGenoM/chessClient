package mobi.mpk.chessandroid.controller;

import java.util.Map;

import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.game.Game;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.Presenter;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.ResultType;

/**
 * Created by evgen on 10.10.17.
 */

public class GameController implements Controller {

    private Game game;
    private GameData gameData;
    private Presenter presenter;

    private String enemyName;
    private String username;

    private Color color;
    private String stroke;

    public GameController(GameData gameData, Presenter presenter) {
        this.gameData = gameData;
        this.presenter = presenter;
    }

    @Override
    public void setGame(Game game, String username, String enemy) {
        this.game = game;
        this.username = username;
        this.enemyName = enemy;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean checkExistGame() {

        if (game == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean checkExistFigure(char x, int y) {

        return game.checkExistFigure(x, y);

    }

    @Override
    public boolean checkExistFigure(String cordinate) {

        char x = cordinate.charAt(0);
        int y = Character.digit(cordinate.charAt(1), 10);

        return game.checkExistFigure(x, y, color);

    }

    @Override
    public Map<String, Enum> getFigureData(char x, int y) {

        return game.getFigureData(x, y);

    }

    @Override
    public void handleStroke(String coordinateCell) {

        char x = coordinateCell.charAt(0);
        int y = Integer.parseInt(String.valueOf(coordinateCell.charAt(1)));

        if (game.checkExistFigure(x, y, color)) {

            presenter.update();

            stroke = coordinateCell;
            presenter.setHighlightCell(coordinateCell);

        } else {

            stroke += " " + coordinateCell;
            move(username, stroke);

            stroke = "";

        }

    }

    @Override
    public String getNameEnemy() {

        return enemyName;

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void move(String name, String stroke) {

        ResultType result = game.doStroke(new User(name), stroke);
        gameData.setResultGame(result);

    }

    public Game getGame() {
        return game;
    }

    public void update() {

        presenter.update();

    }
}
