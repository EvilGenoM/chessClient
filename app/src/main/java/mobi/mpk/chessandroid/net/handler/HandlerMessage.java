package mobi.mpk.chessandroid.net.handler;


import mobi.mpk.chessandroid.net.message.MessageResponse;

public interface HandlerMessage {

    void handle(MessageResponse messageResponse);

}
