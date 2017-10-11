package mobi.mpk.chessandroid.di.module;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;

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

    public ViewModule(@NonNull Context context, @NonNull Canvas canvas) {
        this.context = context;
        this.canvas = canvas;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public Canvas provideCanvas() {
        return canvas;
    }

}
