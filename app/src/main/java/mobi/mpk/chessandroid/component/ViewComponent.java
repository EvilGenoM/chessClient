package mobi.mpk.chessandroid.component;

import dagger.Component;
import mobi.mpk.chessandroid.MainActivity;
import mobi.mpk.chessandroid.module.BoardViewModule;
import mobi.mpk.chessandroid.module.UtilsModule;
import mobi.mpk.chessandroid.module.ViewModule;
import mobi.mpk.chessandroid.view.CellView;

/**
 * Created by evgen on 10.10.17.
 */

@Component(modules = {ViewModule.class, UtilsModule.class, BoardViewModule.class})
public interface ViewComponent {

    void inject(CellView cellView);

}
