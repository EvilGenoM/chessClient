package mobi.mpk.chessandroid.presenter.game.out;


import java.util.Map;

public interface GamePresenterOut {

    void makeMove(String move);

    void stopGame();

    boolean checkExistFigure(char x, int y);

    boolean checkExistFigure(String cordinate);

    Map<String, Enum> getFigureData(char x, int y);

    void handleGameEvent(String coordinateCell);

    boolean checkExistGame();
}
