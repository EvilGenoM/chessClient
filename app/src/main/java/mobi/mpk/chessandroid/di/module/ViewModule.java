package mobi.mpk.chessandroid.di.module;

import android.content.Context;
import android.graphics.Canvas;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by evgen on 10.10.17.
 */

@Module
public class ViewModule {

    private Context context;
    private Canvas canvas;

    public ViewModule(Context context, Canvas canvas) {
        this.context = context;
        this.canvas = canvas;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    Canvas provideCanvas() {
        return canvas;
    }

}
