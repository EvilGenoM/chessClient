package mobi.mpk.chessandroid.net.handler;


import mobi.mpk.chessandroid.repository.out.RepositoryOut;
import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.net.message.MessageResponse;
import mobi.mpk.chessandroid.type.Color;

class GameHandlerMessage implements HandlerMessage {

    private final int NUMBER_CELLS = 2;
    private final int LENGTH_NAME_CELL = 2;

    private RepositoryOut repository;

    public GameHandlerMessage(RepositoryOut repository) {

        this.repository = repository;

    }

    @Override
    public void handle(MessageResponse messageResponse) {

        switch (messageResponse.getType()) {

            case GAME_START:
                startGame(messageResponse.getText());
                break;
            case GAME_COLOR:
                initGameColor(messageResponse.getText());
                break;
            case GAME_STOP:
                stopGame(messageResponse.getText());
                break;
            case MOVE:
                makeMove(messageResponse.getUsername(), messageResponse.getText());
                break;

        }

    }

    private void startGame(String username) {

        User user = new User(username);
        repository.startGame(user);

    }

    private void stopGame(String message) {

        if (message.equals("win")) {

            repository.wonUser();

        } else if (message.equals("loss")) {

            repository.lostUser();

        } else {

            repository.stopGame("Game End");

        }

    }

    private void initGameColor(String color) {

        Color colorPiece;
        if (color.equals("white")) {

            colorPiece = Color.white;

        } else {

            colorPiece = Color.black;

        }

        repository.initColorPieces(colorPiece);

    }

    private void makeMove(String username, String move) {

        if (moveValidate(move)) {

            repository.makeMove(username, move);

        }

    }

    private boolean moveValidate(String move) {

        String[] cells = move.split(" ");

        if (cells.length != NUMBER_CELLS &&
                (cells[0].length() != LENGTH_NAME_CELL || cells[1].length() != LENGTH_NAME_CELL)) {

            return false;

        }

        for (int i = 0; i < cells.length; i++) {

            char letter = cells[i].charAt(0);
            int number = Character.digit(cells[i].charAt(1), 10);

            if(letter < 'a' || letter > 'h') {

                return false;

            } else if(number < 1 || number > 8) {

                return false;

            }

        }

        return true;
    }


}
