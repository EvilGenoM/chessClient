package mobi.mpk.chessandroid.interactor.in;

import java.util.Map;

import mobi.mpk.chessandroid.interactor.stategame.StateGame;
import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.ResultType;

public class NetInteractorIn implements InteractorIn {

    private StateGame stateGame;

    private GameData gameData;

    public NetInteractorIn(StateGame stateGame, GameData gameData) {

        this.stateGame = stateGame;
        this.gameData = gameData;

    }

    @Override
    public void startGame(User user1, User user2) {

        stateGame.createGame(user1, user2);

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
    public ResultType makeMove(String username, String move) {

        User user = stateGame.getUser(username);
        ResultType resultType = stateGame.getGame().doStroke(user, move);

        gameData.setResultGame(resultType);

        return resultType;

    }

    @Override
    public void wonUser() {

    }

    @Override
    public void lostUser() {

    }

    @Override
    public boolean checkExistFigure(char x, int y) {
        return stateGame.getGame().checkExistFigure(x, y);
    }

    @Override
    public boolean checkExistFigure(char x, int y, String username) {

        User user = stateGame.getUser(username);
        return stateGame.getGame().checkExistFigure(x, y, user);

    }

    @Override
    public Map<String, Enum> getFigureData(char x, int y) {
        return stateGame.getGame().getFigureData(x, y);
    }

    @Override
    public boolean checkExistGame() {
        return stateGame.checkExistGame();
    }

}
