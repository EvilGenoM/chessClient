package mobi.mpk.chessandroid.presenter.lobby.in;


import android.content.Context;
import android.content.Intent;

import mobi.mpk.chessandroid.ui.game.GameActivity;
import mobi.mpk.chessandroid.ui.main.MainActivity;

public class DefaultLobbyPresenterIn implements LobbyPresenterIn {

    private Context context;

    @Override
    public void setActivity(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public void openDialogWait(String message) {



    }

    @Override
    public void closeDialogWait(String message) {



    }

    @Override
    public void startGame() {

        Intent intent = new Intent(context, GameActivity.class);
        context.startActivity(intent);

    }

    @Override
    public void abortGame() {

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

}
