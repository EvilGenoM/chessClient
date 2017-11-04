package mobi.mpk.chessandroid.presenter.lobby.out;


import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.interactor.in.InteractorIn;
import mobi.mpk.chessandroid.presenter.lobby.in.LobbyPresenterIn;

public class LocalLobbyPresenterOut implements LobbyPresenterOut {

    private LobbyPresenterIn lobbyPresenterIn;
    private InteractorIn interactorIn;

    public LocalLobbyPresenterOut(LobbyPresenterIn lobbyPresenterIn, InteractorIn interactorIn) {

        this.lobbyPresenterIn = lobbyPresenterIn;
        this.interactorIn = interactorIn;

    }

    @Override
    public void startRandomGame() {

        lobbyPresenterIn.startGame();
        User user = new User("One");
        User user2 = new User("Two");
        interactorIn.startGame(user, user2);

    }

    @Override
    public void cancelRandomGame() {



    }

}
