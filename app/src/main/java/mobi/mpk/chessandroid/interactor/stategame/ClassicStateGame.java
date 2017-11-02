package mobi.mpk.chessandroid.interactor.stategame;


import mobi.mpk.chessandroid.domain.User;
import mobi.mpk.chessandroid.domain.game.ClassicGame;
import mobi.mpk.chessandroid.domain.game.Game;

class ClassicStateGame implements StateGame {

    private Game game;
    private User user1;
    private User user2;

    @Override
    public void createGame(User user1, User user2) {

        game = new ClassicGame(user1, user2);

    }

    @Override
    public void distroyGame() {

        game = null;

    }

    @Override
    public boolean checkExistGame() {

        if (game == null) {

            return false;

        } else {

            return true;

        }

    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public User getUser(String username) {

        if(user1.getName().equals(username)) {

            return user1;

        } else {

            return user2;

        }

    }

    @Override
    public User getUser1() {
        return user1;
    }

    @Override
    public User getUser2() {
        return user2;
    }

    @Override
    public void setUser1(User user) {
        this.user1 = user;
    }

    @Override
    public void setUser2(User user) {
        this.user2 = user;
    }

}
