package mobi.mpk.chessandroid.presenter;


import android.content.Context;
import android.content.Intent;

import mobi.mpk.chessandroid.ui.GameActivity;
import mobi.mpk.chessandroid.ui.game_view.GameView;

public class GamePresenter implements Presenter{

    private GameView gameView;
    private Context context;

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void openWaitingGame() {



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
    public void openGame() {

        Intent intent = new Intent(context, GameActivity.class);
        context.startActivity(intent);

    }

}
