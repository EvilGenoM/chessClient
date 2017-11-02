package mobi.mpk.chessandroid.presenter.lobby.in;


import android.content.Context;

public interface LobbyPresenterIn {

    void openDialogWait(String message);

    void closeDialogWait(String message);

    void startGame();

    void setActivity(Context context);

    void abortGame();
}
