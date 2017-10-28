package mobi.mpk.chessandroid.presenter;


import android.content.Context;

public interface Presenter {

    void setHighlightCell(String coordonateCell);

    void update();

    void openGame();

    void setContext(Context context);

    void openWaitingGame();
}
