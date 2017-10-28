package mobi.mpk.chessandroid.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.java_websocket.WebSocket;

import java.util.Random;

import javax.inject.Inject;

import mobi.mpk.chessandroid.iterator.Iterator;
import mobi.mpk.chessandroid.type.Color;
import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class NetworkSocket {

    @Inject
    Iterator iterator;

    private StompClient mStompClient;
    private Gson gson = new GsonBuilder().create();
    private String username;
    private String URL = "ws://176.214.146.67:8080/ws";

    public NetworkSocket() {

        mStompClient = Stomp.over(WebSocket.class, URL);
        mStompClient.connect();

        username = createRandomName();

        mStompClient.topic("/channel/" + username).subscribe(topicMessage -> {

            handleReply(gson.fromJson(topicMessage.getPayload(), Message.class));

        });

        String jsonMessage = createMessage(username, Message.MessageType.CREATE_USER);
        mStompClient.send("/app/server.addName", jsonMessage).subscribe();

    }

    private String createMessage(String name, Message.MessageType type) {

        return createMessage(name, null, type);

    }

    private String createMessage(String name, String text, Message.MessageType type) {

        Message message = new Message();

        message.setSender(name);
        message.setContent(text);
        message.setType(type);

        return gson.toJson(message);

    }

    private String createRandomName() {

        String name = "";

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int symbolNum = random.nextInt(67);

            if (symbolNum < 10) {

                symbolNum += 48;

            } else {

                symbolNum += 55;

            }

            char symbol = (char) symbolNum;
            name += symbol;

        }
        return name;

    }


    private void handleReply(Message message) {

        if (message.getType().equals(Message.MessageType.GAME_START)) {

            iterator.startGame(username, message.getContent());

        } else if (message.getType().equals(Message.MessageType.GAME_COLOR)) {

            Color color;

            if(message.getContent().equals("white")) {
                color = Color.white;
            } else {
                color = Color.black;
            }

            iterator.initColorPlayer(color);

        } else if (message.getType().equals(Message.MessageType.RANDOM_GAME_WAIT)) {

            iterator.waitGame();

        }

    }

    public void startRandomGame() {



    }

}
