package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.interactor.stategame.ClassicStateGame;
import mobi.mpk.chessandroid.interactor.stategame.StateGame;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.ui.setting.Settings;

@Module
public class GameModule {

    private final Settings settings;
    private final StateGame stateGame;
    private final GameData gameData;

    public GameModule(){
        this.gameData = new GameData();
        this.stateGame = new ClassicStateGame();
        this.settings = new Settings();
    }

    @Provides
    @Singleton
    public GameData provideGameData() {
        return gameData;
    }

    @Provides
    @Singleton
    public StateGame provideStateGame() {
        return stateGame;
    }

    @Provides
    @Singleton
    public Settings provideSettings() {
        return settings;
    }

}
