package mobi.mpk.chessandroid.presenter;


import mobi.mpk.chessandroid.ui.game_view.GameView;

public class GamePresenter implements Presenter{

    private GameView gameView;

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    @Override
    public void setHighlightCell(String coordonateCell) {

        gameView.setHighlightCell(coordonateCell);
        gameView.invalidate();

    }

    @Override
    public void update() {

        gameView.update();

    }
}
