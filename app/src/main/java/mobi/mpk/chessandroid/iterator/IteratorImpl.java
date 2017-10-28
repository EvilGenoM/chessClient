package mobi.mpk.chessandroid.iterator;


import javax.inject.Inject;

import mobi.mpk.chessandroid.controller.Controller;
import mobi.mpk.chessandroid.net.NetworkSocket;
import mobi.mpk.chessandroid.presenter.Presenter;
import mobi.mpk.chessandroid.type.Color;

public class IteratorImpl implements  Iterator {

    @Inject
    Controller controller;
    @Inject
    Presenter presenter;
    @Inject
    NetworkSocket networkSocket;

    @Override
    public void doStroke(String stroke) {

    }

    @Override
    public void startGame(String username, String enemyname) {

    }

    @Override
    public void initColorPlayer(Color color) {

    }

    @Override
    public void waitGame() {

    }
}
