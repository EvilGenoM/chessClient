package mobi.mpk.chessandroid.presenter;


import android.content.Context;

public interface PresenterIn {

    void openDialogWait(String message);

    void closeDialogWait(String message);

    void startGame();

    void makeMove(String move);

    void setActivity(Context context);

}
