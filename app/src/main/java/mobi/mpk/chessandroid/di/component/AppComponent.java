package mobi.mpk.chessandroid.di.component;

import javax.inject.Singleton;

import dagger.Component;
import mobi.mpk.chessandroid.di.module.CommunicationModule;
import mobi.mpk.chessandroid.di.module.DrawerModule;
import mobi.mpk.chessandroid.di.module.GameModule;
import mobi.mpk.chessandroid.di.module.NetModule;
import mobi.mpk.chessandroid.di.module.ViewModule;
import mobi.mpk.chessandroid.net.listener.server.ServerWebSocketListener;
import mobi.mpk.chessandroid.ui.actionbar.ActionBar;
import mobi.mpk.chessandroid.ui.game.GameActivity;
import mobi.mpk.chessandroid.ui.game.view.CellView;
import mobi.mpk.chessandroid.ui.game.view.FigureView;
import mobi.mpk.chessandroid.ui.game.view.GameView;
import mobi.mpk.chessandroid.ui.main.MainActivity;
import mobi.mpk.chessandroid.ui.main.StartGameView;
import mobi.mpk.chessandroid.ui.setting.SettingsActivity;

@Component(modules = {ViewModule.class, DrawerModule.class, GameModule.class, CommunicationModule.class, NetModule.class})
@Singleton
public interface AppComponent {

    void inject(CellView cellView);

    void inject(SettingsActivity settingsActivity);

    void inject(FigureView figureView);

    void inject(GameActivity gameActivity);

    void inject(MainActivity mainActivity);

    void inject(GameView gameView);

    void inject(StartGameView startGameView);

    void inject(ActionBar actionBar);

    void inject(ServerWebSocketListener listener);

}
