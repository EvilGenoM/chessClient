package mobi.mpk.chessandroid.interactor.stategame;


import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.game.Game;

public interface StateGame {

    void createGame(User user1, User user2);

    void distroyGame();

    boolean checkExistGame();

    Game getGame();

    User getUser(String username);

    User getUser1();

    User getUser2();

    void setUser1(User user);

    void setUser2(User user);

}
