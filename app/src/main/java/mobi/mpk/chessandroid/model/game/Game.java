package mobi.mpk.chessandroid.model.game;


import java.util.List;
import java.util.Map;

import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Player;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.ResultType;

public abstract class Game {

    public static final String TO = "to";

    private Player player1;
    private Player player2;

    private Board board;

    private String name;

    public Game(User user1, User user2) {

        this.player1 = new Player(user1);
        this.player2 = new Player(user2);

        this.name = user1.getName()+ TO +user2.getName();

        this.player1.setColorFigures(Color.white);
        this.player2.setColorFigures(Color.black);

        try {

            this.board = new Board();

        } catch (CellCorrectException e) {
            e.printStackTrace();
        }

    }

    public abstract void initBoard();

    public abstract ResultType doStroke(User user, String stroke);

    public abstract List<Figure> getListFiguresOnBoard();

    protected Player getPlayer1() {
        return this.player1;
    }

    protected Player getPlayer2() {
        return this.player2;
    }

    protected Board getBoard() {
        return this.board;
    }

    public String getName() {
        return name;
    }

    public abstract boolean checkExistFigure(char x, int y);

    public abstract Map<String,Enum> getFigureData(char x, int y);

}
