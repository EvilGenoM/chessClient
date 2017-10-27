package mobi.mpk.chessandroid.net;

import org.java_websocket.WebSocket;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class NetworkSocket {

    private StompClient mStompClient;

    public NetworkSocket() {

        mStompClient = Stomp.over(WebSocket.class, "ws://176.214.146.67:8080/ws");
        mStompClient.connect();

        mStompClient.topic("/channel/public").subscribe();


    }


}
