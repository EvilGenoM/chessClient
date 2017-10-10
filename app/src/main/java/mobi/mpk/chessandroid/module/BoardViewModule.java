package mobi.mpk.chessandroid.module;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.ui.Drawer;
import mobi.mpk.chessandroid.ui.BoardView;

/**
 * Created by evgen on 10.10.17.
 */

@Module
public class BoardViewModule {

    private int lengthSide;

    public BoardViewModule(int lengthSide){
        this.lengthSide = lengthSide;
    }

    @Provides
    @NonNull
    @Singleton
    public BoardView provideBoardView(){
        return new BoardView(lengthSide);
    }

}
