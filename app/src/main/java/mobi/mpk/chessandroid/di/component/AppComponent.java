package mobi.mpk.chessandroid.di.component;

import javax.inject.Singleton;

import dagger.Component;
import mobi.mpk.chessandroid.di.module.ComunicationModule;
import mobi.mpk.chessandroid.di.module.DrawerModule;
import mobi.mpk.chessandroid.di.module.GameModule;
import mobi.mpk.chessandroid.di.module.NetModule;
import mobi.mpk.chessandroid.di.module.ViewModule;
import mobi.mpk.chessandroid.ui.actionbar.ActionBar;
import mobi.mpk.chessandroid.ui.game.GameActivity;
import mobi.mpk.chessandroid.ui.game.view.CellView;
import mobi.mpk.chessandroid.ui.game.view.FigureView;
import mobi.mpk.chessandroid.ui.game.view.GameView;
import mobi.mpk.chessandroid.ui.main.MainActivity;
import mobi.mpk.chessandroid.ui.main.StartGameView;

@Component(modules = {ViewModule.class, DrawerModule.class, GameModule.class, ComunicationModule.class, NetModule.class})
@Singleton
public interface AppComponent {

    void inject(CellView cellView);

    void inject(FigureView figureView);

    void inject(GameActivity gameActivity);

    void inject(MainActivity mainActivity);

    void inject(GameView gameView);

    void inject(StartGameView startGameView);

    void inject(ActionBar actionBar);

}
