package mobi.mpk.chessandroid.net.handler;


import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.net.message.MessageResponse;
import mobi.mpk.chessandroid.repository.out.RepositoryOut;

class LobbyHandlerMessage implements HandlerMessage {

    private RepositoryOut repository;

    public LobbyHandlerMessage(RepositoryOut repository) {

        this.repository = repository;

    }

    @Override
    public void handle(MessageResponse messageResponse) {

        switch (messageResponse.getType()) {

            case RANDOM_GAME_START:
                startRandomGame(messageResponse.getText());
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

        repository.cancelRandomGame(message);

    }

    private void startRandomGame(String username) {

        repository.startRandomGame();
        repository.startGame(new User(username));

    }

    private void waitRandomGame() {

        repository.waitRandomGame();

    }

}
