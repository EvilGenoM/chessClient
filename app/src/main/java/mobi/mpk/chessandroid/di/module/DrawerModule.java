package mobi.mpk.chessandroid.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.ui.game.drawer.Drawer;

/**
 * Created by evgen on 10.10.17.
 */

@Module
public class DrawerModule {

    @Provides
    @Singleton
    public Drawer provideDrawer(Context context) {
        return new Drawer(context);
    }

}