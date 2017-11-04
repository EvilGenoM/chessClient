package mobi.mpk.chessandroid.net.listener.server;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mobi.mpk.chessandroid.net.handler.manager.DefaultManagerHandlerMessage;
import mobi.mpk.chessandroid.net.handler.manager.ManagerHandlerMessage;
import mobi.mpk.chessandroid.net.message.MessageRequest;
import mobi.mpk.chessandroid.net.message.MessageResponse;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;


public class ServerWebSocketListener extends WebSocketListener {

    private Gson gson;

    private ManagerHandlerMessage managerHandler;

    private String username;
    public ServerWebSocketListener() {

        gson = new GsonBuilder().create();
        managerHandler = new DefaultManagerHandlerMessage();
        username = "Anonymuos";

    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {

        MessageRequest messageRequest = new MessageRequest(username, "connect", MessageRequest.MessageType.CONNECTION);
        String jsonMessage = gson.toJson(messageRequest);

        webSocket.send(jsonMessage);

    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {

        MessageResponse messageResponse = gson.fromJson(text, MessageResponse.class);

        managerHandler.transfer(messageResponse);

    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {

        MessageRequest messageRequest = new MessageRequest(username, "disconnect", MessageRequest.MessageType.DISCONNECTION);
        String jsonMessage = gson.toJson(messageRequest);

        webSocket.send(jsonMessage);

    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
    }

}
