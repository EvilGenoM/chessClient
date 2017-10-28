package mobi.mpk.chessandroid.iterator;


import javax.inject.Inject;

import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.game.ClassicGame;
import mobi.mpk.chessandroid.model.game.Game;
import mobi.mpk.chessandroid.net.NetworkSocket;
import mobi.mpk.chessandroid.presenter.GamePresenter;
import mobi.mpk.chessandroid.type.Color;

public class IteratorImpl implements  Iterator {

    private NetworkSocket net;

    @Inject
    GameController controller;

    private GamePresenter presenter;

    public IteratorImpl(GamePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getStroke(String stroke) {
        controller.move(controller.getUsername(), stroke);
    }

    @Override
    public void startGame(String username, String enemyname) {

        User user = new User(username);
        User enemy = new User(enemyname);

        Game game = new ClassicGame(user, enemy);

        controller.setGame(game, username, enemyname);
        presenter.openGame();

    }

    @Override
    public void initColorPlayer(Color color) {

        controller.setColor(color);

    }

    @Override
    public void waitGame() {

        presenter.openWaitingGame();

    }

    @Override
    public void startRandomGame() {

        net.sendRequestRandomGame();

    }

    @Override
    public void sendStroke(String stroke) {

        net.sendStroke(controller.getNameEnemy(), stroke);

    }

    public void socketError() {

        presenter.toastShow("Ошибка подключения");

    }

    public void setNet(NetworkSocket net) {
        this.net = net;
    }
}
