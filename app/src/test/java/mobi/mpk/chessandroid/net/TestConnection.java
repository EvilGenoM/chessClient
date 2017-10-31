package mobi.mpk.chessandroid.net;

import org.junit.Test;
import org.mockito.Mockito;

import okhttp3.OkHttpClient;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestConnection {

    @Test
    public void testConnect() {

        OkHttpClient webSocketClient = mock(OkHttpClient.class);

        WebSocketConnection webSocketConnection = new WebSocketConnection(new OkHttpClient());
        WebSocketConnection spyWebSocketConnection = Mockito.spy(webSocketConnection);

        spyWebSocketConnection.connect();

        verify(webSocketClient).newWebSocket(any(), any());

    }

}


