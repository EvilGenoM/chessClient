package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.GamePresenter;

@Module
public class GameModule {

    private GameData gameData;
    private GamePresenter gamePresenter;

    public GameModule(){
        this.gameData = new GameData();
        this.gamePresenter = new GamePresenter();
    }

    @Provides
    @Singleton
    public GameData provideGameData() {
        return gameData;
    }

    @Provides
    @Singleton
    public GamePresenter provideGamePresenter() {
        return gamePresenter;
    }

}
