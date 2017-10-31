package mobi.mpk.chessandroid.net.message;


public class MessageRequest {

    private String username;
    private String text;
    private MessageType type;

    public MessageRequest() {

    }

    public MessageRequest(String username, String text, MessageType type) {

        this.username = username;
        this.text = text;
        this.type = type;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public enum MessageType {

        CONNECTION, DISCONNECTION,
        RANDOM_GAME_FIND, RANDOM_GAME_CANCEL,
        GAME_START, GAME_STOP,
        MOVE;

    }

}
