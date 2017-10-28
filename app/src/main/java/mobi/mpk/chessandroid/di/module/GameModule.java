package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.GamePresenter;
import mobi.mpk.chessandroid.presenter.Presenter;
import mobi.mpk.chessandroid.ui.Settings;

@Module
public class GameModule {

    private final Settings settings;
    private final GameData gameData;
    private final Presenter gamePresenter;

    public GameModule(){
        this.gameData = new GameData();
        this.gamePresenter = new GamePresenter();
        this.settings = new Settings();
    }

    @Provides
    @Singleton
    public GameData provideGameData() {
        return gameData;
    }

    @Provides
    @Singleton
    public Presenter provideGamePresenter() {
        return gamePresenter;
    }

    @Provides
    @Singleton
    public Settings provideSettings() {
        return settings;
    }

}
