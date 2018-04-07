package mobi.mpk.chessandroid.repository.in;


public interface RepositoryIn {

    void startRandomGame();

    void cancelRandomGame();

    void sendMove(String move);

    void stopGame();

}
