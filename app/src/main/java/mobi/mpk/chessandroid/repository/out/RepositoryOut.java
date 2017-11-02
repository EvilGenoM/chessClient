package mobi.mpk.chessandroid.repository.out;


import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.type.Color;

public interface RepositoryOut {

    void startRandomGame();

    void waitRandomGame();

    void cancelRandomGame(String message);

    void startGame(User user);

    void stopGame(String message);

    void initColorPieces(Color color);

    void makeMove(String username, String move);

    void wonUser();

    void lostUser();

}
