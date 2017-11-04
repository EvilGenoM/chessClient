package mobi.mpk.chessandroid.net;


import mobi.mpk.chessandroid.net.listener.server.ServerWebSocketListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketConnection implements Connection {

    private static final int NORMAL_CLOSURE_STATUS = 1000;

    private OkHttpClient client;
    private WebSocket webSocket;

    public WebSocketConnection() {

        client = new OkHttpClient();

    }

    @Override
    public void connection() {

        Request request = new Request.Builder().url("ws://localhost:8080/ws/").build();
        WebSocketListener webSocketListener = new ServerWebSocketListener();

        webSocket = client.newWebSocket(request, webSocketListener);

    }

    @Override
    public void disconnection() {

        webSocket.close(NORMAL_CLOSURE_STATUS, "WebSocket connect closed");

    }

    public WebSocket getWebSocket() {

        return webSocket;

    }

}
