package mobi.mpk.chessandroid.interactor.in;


import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.ResultType;

public interface InteractorIn {

    void startGame(User user1, User user2);

    void initColorPieces(Color color);

    void stopGame();

    ResultType makeMove(String username, String move);

    void wonUser();

    void lostUser();

}
