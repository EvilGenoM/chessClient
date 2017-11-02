package mobi.mpk.chessandroid.net.listener.client;


public interface ClientWebSocketListener {

    void startRandomGame();

    void cancelRandomGame();

    void makeMove(String move);

    void abortGame();

}
