package mobi.mpk.chessandroid.presenter.game.in;


import mobi.mpk.chessandroid.ui.game_view.GameView;

public interface GamePresenterIn {

    void setGameView(GameView gameView);

    void makeMove(String move);

    void setHighlightCell(String coordonateCell);

    void update();

    void stopGame();

}
