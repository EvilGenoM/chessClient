package mobi.mpk.chessandroid.net.handler.manager;


import mobi.mpk.chessandroid.net.message.MessageRequest;

class DefaultManagerHandlerMessage implements ManagerHandlerMessage {

    @Override
    public void transfer(MessageRequest messageRequest) {

        switch (messageRequest.getType()) {

            case GAME_START:
                
                break;

            case GAME_STOP:

                break;
        }

    }

}
