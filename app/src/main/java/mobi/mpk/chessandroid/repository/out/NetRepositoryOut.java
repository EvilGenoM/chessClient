package mobi.mpk.chessandroid.repository.out;


import mobi.mpk.chessandroid.interactor.in.InteractorIn;
import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.presenter.lobby.in.LobbyPresenterIn;
import mobi.mpk.chessandroid.type.Color;

public class NetRepositoryOut implements RepositoryOut {

    private InteractorIn interactor;
    private LobbyPresenterIn presenter;

    public NetRepositoryOut(InteractorIn interactor, LobbyPresenterIn presenter) {

        this.interactor = interactor;
        this.presenter = presenter;

    }

    @Override
    public void startRandomGame() {

        presenter.startGame();

    }

    @Override
    public void waitRandomGame() {

        presenter.openDialogWait("Wait game");

    }

    @Override
    public void cancelRandomGame(String message) {

        presenter.closeDialogWait(message);

    }

    @Override
    public void startGame(User user2) {

        User user1 = new User("Anonymous");
        interactor.startGame(user1, user2);

    }

    @Override
    public void stopGame(String message) {

        interactor.stopGame();

    }

    @Override
    public void initColorPieces(Color color) {

        interactor.initColorPieces(color);

    }

    @Override
    public void makeMove(String username, String move) {

        interactor.makeMove(username, move);

    }

    @Override
    public void wonUser() {

        interactor.wonUser();

    }

    @Override
    public void lostUser() {

        interactor.lostUser();

    }

}
