package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.observer.model.GameData;

@Module
public class GameDataModule {

    private GameData gameData;

    public GameDataModule(){
        this.gameData = new GameData();
    }

    @Provides
    @Singleton
    public GameData provideGameData() {
        return gameData;
    }


}
