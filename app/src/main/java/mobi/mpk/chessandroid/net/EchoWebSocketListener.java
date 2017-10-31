package mobi.mpk.chessandroid.net;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mobi.mpk.chessandroid.net.handler.manager.ManagerHandlerMessage;
import mobi.mpk.chessandroid.net.message.MessageRequest;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;


class EchoWebSocketListener extends WebSocketListener {

    private Gson gson;

    public EchoWebSocketListener() {

        gson = new GsonBuilder().create();

    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {

        MessageRequest messageRequest = new MessageRequest("username", "connect", MessageRequest.MessageType.CONNECTION);
        String jsonMessage = gson.toJson(messageRequest);

        webSocket.send(jsonMessage);

    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {

        MessageRequest messageRequest = gson.fromJson(text, MessageRequest.class);
        ManagerHandlerMessage managerHandler = new ManagerHandlerMessage();

    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {



    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {

        MessageRequest messageRequest = new MessageRequest("username", "disconnect", MessageRequest.MessageType.DISCONNECTION);
        String jsonMessage = gson.toJson(messageRequest);

        webSocket.send(jsonMessage);

    }

}
