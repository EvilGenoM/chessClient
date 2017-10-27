package mobi.mpk.chessandroid.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.java_websocket.WebSocket;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class NetworkSocket {

    private StompClient mStompClient;
    private Gson gson = new GsonBuilder().create();
    private String username = "Anonymuos";
    private String URL = "ws://176.214.146.67:8080/ws";

    public NetworkSocket() {

        mStompClient = Stomp.over(WebSocket.class, URL);
        mStompClient.connect();

        mStompClient.topic("/channel/public").subscribe(topicMessage -> {

            handleUsers(gson.fromJson(topicMessage.getPayload(), Message.class));

        });

        Message message = new Message();
        message.setSender(username);
        message.setType(Message.MessageType.CREATE_USER);
        String jsonMessage = gson.toJson(message);

        mStompClient.send("/app/server.addName", jsonMessage).subscribe();

    }

    private void handleUsers(Message message) {

        if(message.getSender().equals(username) && message.getType().equals(Message.MessageType.CREATE_USER)) {

            username = message.getContent();

            mStompClient.topic("/channel/"+username).subscribe(topicMessage -> {

                handleReply(gson.fromJson(topicMessage.getPayload(), Message.class));

            });

        }

    }

    private void handleReply(Message message) {



    }


}
