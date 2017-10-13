package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.controller.GameController;

/**
 * Created by evgen on 10.10.17.
 */

@Module
public class GameControllerModule {

    @Provides
    @Singleton
    public GameController provideGameController(){
        return new GameController();
    }

}
