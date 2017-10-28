package mobi.mpk.chessandroid.iterator;


import mobi.mpk.chessandroid.type.Color;

public interface Iterator {

    void doStroke(String stroke);

    void startGame(String username, String enemyname);

    void initColorPlayer(Color color);

    void waitGame();

}