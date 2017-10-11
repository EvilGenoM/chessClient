package mobi.mpk.chessandroid.di.module;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.ui.Drawer;

/**
 * Created by evgen on 10.10.17.
 */

@Module
public class UtilsModule {

   @Provides
   @Singleton
   public Drawer provideDrawer(Context context, Canvas canvas){
       return new Drawer(context, canvas);
   }

}
