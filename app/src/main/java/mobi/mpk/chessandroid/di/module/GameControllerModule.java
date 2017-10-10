package mobi.mpk.chessandroid.di.module;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.ui.BoardView;

/**
 * Created by evgen on 10.10.17.
 */

@Module
public class GameControllerModule {

    @Provides
    @NonNull
    @Singleton
    public GameController provideGameController(){
        return new GameController();
    }

}
