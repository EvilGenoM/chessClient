package mobi.mpk.chessandroid.controller;


import java.util.Map;

import mobi.mpk.chessandroid.domain.game.Game;
import mobi.mpk.chessandroid.type.Color;

public interface Controller {

    void setGame(Game game, String username, String enemy);

    void setColor(Color color);

    Color getColor();

    boolean checkExistGame();

    boolean checkExistFigure(char x, int y);

    boolean checkExistFigure(String cordinate);

    Map<String, Enum> getFigureData(char x, int y);

    void handleStroke(String coordinateCell);

    void move(String name, String stroke);

    String getNameEnemy();

    String getUsername();
}
