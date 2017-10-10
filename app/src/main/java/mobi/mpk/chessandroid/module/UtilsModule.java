package mobi.mpk.chessandroid.module;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;

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
   @NonNull
   @Singleton
   public Drawer provideDrawer(Context context, Canvas canvas){
       return new Drawer(context, canvas);
   }

}
