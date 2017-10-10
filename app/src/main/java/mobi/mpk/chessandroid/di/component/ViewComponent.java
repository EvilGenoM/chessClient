package mobi.mpk.chessandroid.di.component;

import javax.inject.Singleton;

import dagger.Component;
import mobi.mpk.chessandroid.di.module.BoardViewModule;
import mobi.mpk.chessandroid.di.module.GameControllerModule;
import mobi.mpk.chessandroid.di.module.UtilsModule;
import mobi.mpk.chessandroid.di.module.ViewModule;
import mobi.mpk.chessandroid.ui.CellView;
import mobi.mpk.chessandroid.ui.FigureView;

/**
 * Created by evgen on 10.10.17.
 */

@Component(modules = {ViewModule.class, UtilsModule.class, BoardViewModule.class, GameControllerModule.class})
@Singleton
public interface ViewComponent {

    void inject(CellView cellView);

    void inject(FigureView figureView);

}
