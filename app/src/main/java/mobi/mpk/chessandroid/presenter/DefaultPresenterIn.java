package mobi.mpk.chessandroid.presenter;


import android.content.Context;

class DefaultPresenterIn implements PresenterIn {

    private Context context;

    @Override
    public void openDialogWait(String message) {

    }

    @Override
    public void closeDialogWait(String message) {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void makeMove(String move) {

    }

    @Override
    public void setActivity(Context context) {
        this.context = context;
    }

}
