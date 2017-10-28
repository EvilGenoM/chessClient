package mobi.mpk.chessandroid.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.controller.Controller;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.iterator.Iterator;
import mobi.mpk.chessandroid.iterator.IteratorImpl;
import mobi.mpk.chessandroid.net.NetworkSocket;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.Presenter;
import mobi.mpk.chessandroid.ui.game_view.Drawer;

/**
 * Created by evgen on 10.10.17.
 */

@Module
public class UtilsModule {

    @Provides
    @Singleton
    public Drawer provideDrawer(Context context) {
        return new Drawer(context);
    }

    @Provides
    @Singleton
    public Controller provideGameController(GameData gameData, Presenter presenter) {
        return new GameController(gameData, presenter);
    }

    @Provides
    @Singleton
    public Iterator provideIterator() {
        return new IteratorImpl();
    }

    @Provides
    @Singleton
    public NetworkSocket provideWebSocket() {
        return new NetworkSocket();
    }

}
