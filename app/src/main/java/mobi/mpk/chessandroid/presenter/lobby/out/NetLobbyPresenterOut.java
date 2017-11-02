package mobi.mpk.chessandroid.presenter.lobby.out;


import mobi.mpk.chessandroid.repository.in.RepositoryIn;

public class NetLobbyPresenterOut implements LobbyPresenterOut {

    private RepositoryIn repository;

    public NetLobbyPresenterOut(RepositoryIn repository) {

        this.repository= repository;

    }

    @Override
    public void startRandomGame() {

        repository.startRandomGame();

    }

    @Override
    public void cancelRandomGame() {

        repository.cancelRandomGame();

    }

}
