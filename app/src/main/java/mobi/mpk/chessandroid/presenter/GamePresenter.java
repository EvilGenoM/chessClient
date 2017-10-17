package mobi.mpk.chessandroid.presenter;


import mobi.mpk.chessandroid.ui.game_view.GameView;

public class GamePresenter {

    private GameView gameView;

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public void setHighlightCell(String coordonateCell) {

        gameView.setHighlightCell(coordonateCell);
        gameView.invalidate();

    }

    public void update() {

        gameView.update();

    }
}