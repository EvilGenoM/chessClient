package mobi.mpk.chessandroid.presenter.game.out;


import java.util.Map;

import mobi.mpk.chessandroid.interactor.in.InteractorIn;
import mobi.mpk.chessandroid.presenter.game.in.GamePresenterIn;
import mobi.mpk.chessandroid.type.ResultType;

public class LocalGamePresenterOut implements GamePresenterOut {

    private InteractorIn interactor;

    private GamePresenterIn presenter;

    private String stroke;
    private String username1;
    private String username2;
    private boolean white;

    public LocalGamePresenterOut(InteractorIn interactor, GamePresenterIn presenter) {

        this.interactor = interactor;

        this.presenter = presenter;
        this.username1 = "One";
        this.username2 = "Two";
        this.white = true;

    }

    @Override
    public void makeMove(String move) {

        ResultType resultType;

        if(white) {
            resultType = interactor.makeMove(username1, move);
        } else {
            resultType = interactor.makeMove(username2, move);
        }

        if(resultType == ResultType.SUCCESS || resultType == ResultType.ATTACK) {
            white = !white;
        }

    }

    @Override
    public void stopGame() {

        interactor.stopGame();

    }

    @Override
    public boolean checkExistFigure(char x, int y) {

        return interactor.checkExistFigure(x, y);

    }

    @Override
    public boolean checkExistFigure(String cordinate) {

        char x = cordinate.charAt(0);
        int y = Character.digit(cordinate.charAt(1), 10);

        String username;

        if(white) {
            username = username1;
        } else {
            username = username2;
        }

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

        String username;

        if(white) {
            username = username1;
        } else {
            username = username2;
        }

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
