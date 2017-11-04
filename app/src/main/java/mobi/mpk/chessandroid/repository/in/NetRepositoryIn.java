package mobi.mpk.chessandroid.repository.in;


import mobi.mpk.chessandroid.net.listener.client.ClientWebSocketListener;

public class NetRepositoryIn implements RepositoryIn {

    private ClientWebSocketListener listener;

    public NetRepositoryIn(ClientWebSocketListener listener) {

        this.listener = listener;

    }

    @Override
    public void startRandomGame() {

        listener.startRandomGame();

    }

    @Override
    public void cancelRandomGame() {

        listener.cancelRandomGame();

    }

    @Override
    public void sendMove(String move) {

        listener.makeMove(move);

    }

    @Override
    public void stopGame() {

        listener.abortGame();

    }

}
