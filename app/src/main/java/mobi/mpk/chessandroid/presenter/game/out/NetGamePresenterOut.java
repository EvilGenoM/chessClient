package mobi.mpk.chessandroid.presenter.game.out;


import java.util.Map;

import mobi.mpk.chessandroid.interactor.in.InteractorIn;
import mobi.mpk.chessandroid.presenter.game.in.GamePresenterIn;
import mobi.mpk.chessandroid.repository.in.RepositoryIn;
import mobi.mpk.chessandroid.type.ResultType;

public class NetGamePresenterOut implements GamePresenterOut {

    private RepositoryIn repository;
    private InteractorIn interactor;

    private GamePresenterIn presenter;

    private String stroke;
    private String username;

    public NetGamePresenterOut(RepositoryIn repository, InteractorIn interactor, GamePresenterIn presenter) {

        this.repository = repository;
        this.interactor = interactor;

        this.presenter = presenter;
        this.username = "Anonymous";

    }

    @Override
    public void makeMove(String move) {

        ResultType resultType = interactor.makeMove(username, move);

        if(resultType == ResultType.SUCCESS || resultType == ResultType.ATTACK) {

            repository.sendMove(move);

        }

    }

    @Override
    public void stopGame() {

        interactor.stopGame();
        repository.stopGame();

    }

    @Override
    public boolean checkExistFigure(char x, int y) {

        return interactor.checkExistFigure(x, y);

    }

    @Override
    public boolean checkExistFigure(String cordinate) {

        char x = cordinate.charAt(0);
        int y = Character.digit(cordinate.charAt(1), 10);

        return interactor.checkExistFigure(x, y, username);

    }

    @Override
    public Map<String, Enum> getFigureData(char x, int y) {

        return interactor.getFigureData(x, y);

    }

    @Override
    public void handleGameEvent(String coordinateCell) {

        char x = coordinateCell.charAt(0);
        int y = Integer.parseInt(String.valueOf(coordinateCell.charAt(1)));

        if (interactor.checkExistFigure(x, y, username)) {

            presenter.update();

            stroke = coordinateCell;
            presenter.setHighlightCell(coordinateCell);

        } else {

            stroke += " " + coordinateCell;

            makeMove(stroke);

            stroke = "";

        }

    }

    @Override
    public boolean checkExistGame() {
        return interactor.checkExistGame();
    }

}
