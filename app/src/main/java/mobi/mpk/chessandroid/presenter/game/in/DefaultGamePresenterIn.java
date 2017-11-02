package mobi.mpk.chessandroid.presenter.game.in;


import mobi.mpk.chessandroid.ui.game_view.GameView;

public class DefaultGamePresenterIn implements GamePresenterIn {

    private GameView gameView;

    @Override
    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    @Override
    public void makeMove(String move) {

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

    @Override
    public void stopGame() {

    }

}
