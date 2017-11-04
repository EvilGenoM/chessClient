package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.iterator.IteratorImpl;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.ui.setting.Settings;

@Module
public class GameModule {

    private final Settings settings;
    private final GameData gameData;
    private final GamePresenter gamePresenter;
    private final IteratorImpl iterator;

    public GameModule(){
        this.gameData = new GameData();
        this.gamePresenter = new GamePresenter();
        this.settings = new Settings();
        this.iterator = new IteratorImpl(gamePresenter);
    }

    @Provides
    @Singleton
    public GameData provideGameData() {
        return gameData;
    }

    @Provides
    @Singleton
    public IteratorImpl provideIteratorImpl() {
        return iterator;
    }

    @Provides
    @Singleton
    public GamePresenter provideGamePresenter() {
        return gamePresenter;
    }

    @Provides
    @Singleton
    public Settings provideSettings() {
        return settings;
    }

}
