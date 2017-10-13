package mobi.mpk.chessandroid.di.component;

import javax.inject.Singleton;

import dagger.Component;
import mobi.mpk.chessandroid.di.module.GameControllerModule;
import mobi.mpk.chessandroid.di.module.UtilsModule;
import mobi.mpk.chessandroid.di.module.ViewModule;
import mobi.mpk.chessandroid.model.game.ClassicGame;
import mobi.mpk.chessandroid.ui.GameActivity;
import mobi.mpk.chessandroid.ui.game_view.CellView;
import mobi.mpk.chessandroid.ui.game_view.FigureView;
import mobi.mpk.chessandroid.ui.game_view.GameView;

@Component(modules = {ViewModule.class, UtilsModule.class, GameControllerModule.class})
@Singleton
public interface AppComponent {

    void inject(CellView cellView);

    void inject(FigureView figureView);

    void inject(GameActivity gameActivity);

    void inject(GameView gameView);

    void inject(ClassicGame classicGame);

}
