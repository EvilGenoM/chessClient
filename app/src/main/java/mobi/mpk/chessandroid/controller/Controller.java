package mobi.mpk.chessandroid.controller;


import java.util.Map;

public interface Controller {

    boolean checkExistGame();

    boolean checkExistFigure(char x, int y);

    boolean checkExistFigure(String cordinate);

    Map<String, Enum> getFigureData(char x, int y);

    void handleStroke(String coordinateCell);

}
