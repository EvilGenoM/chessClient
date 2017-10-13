package mobi.mpk.chessandroid.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.observer.model.GameData;
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
    public GameController provideGameController(GameData gameData) {
        return new GameController(gameData);
    }

}
