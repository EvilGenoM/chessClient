package mobi.mpk.chessandroid.interactor;

import mobi.mpk.chessandroid.interactor.stategame.StateGame;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.type.Color;

public class NetInteractorIn implements InteractorIn {

    private StateGame stateGame;

    public NetInteractorIn(StateGame stateGame) {

        this.stateGame = stateGame;

    }

    @Override
    public void startGame(User user) {

        User localUser = new User("Anonymous");
        User netUser = user;
        stateGame.createGame(localUser, netUser);

    }

    @Override
    public void initColorPieces(Color color) {

        User user = stateGame.getUser1();
        stateGame.getGame().initColor(user, color);

    }

    @Override
    public void stopGame() {

        stateGame.distroyGame();

    }

    @Override
    public void makeMove(String username, String move) {

        User user = stateGame.getUser(username);
        stateGame.getGame().doStroke(user, move);

    }

    @Override
    public void wonUser() {

    }

    @Override
    public void lostUser() {

    }

}
