package mobi.mpk.chessandroid.net.listener;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;

import mobi.mpk.chessandroid.net.listener.server.ServerWebSocketListener;
import mobi.mpk.chessandroid.net.message.MessageResponse;
import okhttp3.WebSocket;

import static org.mockito.Mockito.mock;

public class TestServerListener {

    private ServerWebSocketListener listener;
    private WebSocket webSocket;

    private Gson gson;

    private String username = "Tester";

    @Before
    public void before() {

        listener = new ServerWebSocketListener();
        webSocket = mock(WebSocket.class);

        gson = new GsonBuilder().create();

    }

    public void testOnMessage() {

        MessageResponse messageResponse = new MessageResponse(username, "connect", MessageResponse.ComandType.LOBBY, MessageResponse.MessageType.GAME_START);
        String jsonMessage = gson.toJson(messageResponse);

        listener.onMessage(webSocket, jsonMessage);



    }

}
