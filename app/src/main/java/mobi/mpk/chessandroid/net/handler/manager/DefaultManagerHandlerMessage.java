package mobi.mpk.chessandroid.net.handler.manager;


import mobi.mpk.chessandroid.net.message.MessageResponse;
import mobi.mpk.chessandroid.net.handler.HandlerMessage;

public class DefaultManagerHandlerMessage implements ManagerHandlerMessage {

    private HandlerMessage gameHandlerMessage;
    private HandlerMessage lobbyHandlerMessage;

    public DefaultManagerHandlerMessage() {

        HandlerMessage gameHandlerMessage;

    }

    @Override
    public void transfer(MessageResponse messageResponse) {

        switch (messageResponse.getComand()) {

            case GAME:
                gameHandlerMessage.handle(messageResponse);
                break;

            case LOBBY:
                lobbyHandlerMessage.handle(messageResponse);
                break;

        }

    }

}
