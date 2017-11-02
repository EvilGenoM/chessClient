package mobi.mpk.chessandroid.interactor.in;

import mobi.mpk.chessandroid.interactor.stategame.StateGame;
import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.ResultType;

public class NetInteractorIn implements InteractorIn {

    private StateGame stateGame;

    public NetInteractorIn(StateGame stateGame) {

        this.stateGame = stateGame;

    }

    @Override
    public void startGame(User user1, User user2) {

        stateGame.createGame(user1, user2);

    }

    @Override
    public void initColorPieces(Color color) {

        User user = stateGame.getUser1();
        //stateGame.getGame().initColor(user, color);

    }

    @Override
    public void stopGame() {

        stateGame.distroyGame();

    }

    @Override
    public ResultType makeMove(String username, String move) {

        User user = stateGame.getUser(username);
        ResultType resultType = stateGame.getGame().doStroke(user, move);

        return resultType;

    }

    @Override
    public void wonUser() {

    }

    @Override
    public void lostUser() {

    }

}
