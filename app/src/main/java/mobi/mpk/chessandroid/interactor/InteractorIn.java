package mobi.mpk.chessandroid.interactor;


import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.type.Color;

public interface InteractorIn {

    void startGame(User user);

    void initColorPieces(Color color);

    void stopGame();

    void makeMove(String username, String move);

    void wonUser();

    void lostUser();

}
