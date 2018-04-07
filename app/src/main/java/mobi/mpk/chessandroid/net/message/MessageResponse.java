package mobi.mpk.chessandroid.net.message;


public class MessageResponse {

    private String username;
    private String text;
    private MessageResponse.ComandType comand;
    private MessageResponse.MessageType type;

    public MessageResponse() {

    }

    public MessageResponse(String username, String text, MessageResponse.ComandType comand, MessageResponse.MessageType type) {

        this.username = username;
        this.text = text;
        this.comand = comand;
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

    public MessageResponse.MessageType getType() {
        return type;
    }

    public void setType(MessageResponse.MessageType type) {
        this.type = type;
    }

    public ComandType getComand() {
        return comand;
    }

    public void setComand(ComandType comand) {
        this.comand = comand;
    }

    public enum MessageType {

        RANDOM_GAME_START, RANDOM_GAME_WAIT, RANDOM_GAME_CANCEL,
        GAME_START, GAME_COLOR, GAME_STOP,
        MOVE, MOVE_RESULT;

    }

    public enum  ComandType {

        GAME, LOBBY;

    }

}
