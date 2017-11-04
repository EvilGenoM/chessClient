package mobi.mpk.chessandroid.net.listener.client;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mobi.mpk.chessandroid.net.WebSocketConnection;
import mobi.mpk.chessandroid.net.message.MessageRequest;
import okhttp3.WebSocket;

public class DefaultClientWebSocketListener implements ClientWebSocketListener {

    private WebSocketConnection connection;

    private WebSocket webSocket;
    private Gson gson;

    public DefaultClientWebSocketListener(WebSocketConnection connection) {

        this.connection = connection;

        this.webSocket = connection.getWebSocket();
        this.gson = new GsonBuilder().create();

    }

    @Override
    public void startRandomGame() {

        String jsonMessage = gson.toJson(createMessage(null, MessageRequest.MessageType.RANDOM_GAME_FIND));

        webSocket.send(jsonMessage);

    }

    @Override
    public void cancelRandomGame() {

        String jsonMessage = gson.toJson(createMessage(null, MessageRequest.MessageType.RANDOM_GAME_CANCEL));

        webSocket.send(jsonMessage);

    }

    @Override
    public void makeMove(String move) {

        String jsonMessage = gson.toJson(createMessage(move, MessageRequest.MessageType.MOVE));

        webSocket.send(jsonMessage);

    }

    @Override
    public void abortGame() {

        String jsonMessage = gson.toJson(createMessage(null, MessageRequest.MessageType.GAME_STOP));

        webSocket.send(jsonMessage);

    }

    private MessageRequest createMessage(String text, MessageRequest.MessageType  type) {

        return new MessageRequest("Anonymous", text, type);


    }

}
