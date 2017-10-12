package mobi.mpk.chessandroid.di.module;

import android.content.Context;
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

    public ViewModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

}
