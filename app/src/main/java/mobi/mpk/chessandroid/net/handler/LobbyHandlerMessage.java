package mobi.mpk.chessandroid.net.handler;


import mobi.mpk.chessandroid.net.message.MessageResponse;
import mobi.mpk.chessandroid.presenter.PresenterIn;

class LobbyHandlerMessage implements HandlerMessage {

    private PresenterIn presenter;

    public LobbyHandlerMessage(PresenterIn presenter) {

        this.presenter = presenter;

    }

    @Override
    public void handle(MessageResponse messageResponse) {

        switch (messageResponse.getType()) {

            case RANDOM_GAME_START:
                startRandomGame();
                break;
            case RANDOM_GAME_WAIT:
                waitRandomGame();
                break;
            case RANDOM_GAME_CANCEL:
                cancelRandomGame(messageResponse.getText());
                break;

        }

    }

    private void cancelRandomGame(String message) {

        presenter.closeDialogWait(message);

    }

    private void startRandomGame() {

        presenter.startGame();

    }

    private void waitRandomGame() {

        presenter.openDialogWait("Wait random game");

    }

}
