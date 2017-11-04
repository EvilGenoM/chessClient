package mobi.mpk.chessandroid;

import android.app.Application;
import android.content.SharedPreferences;

import mobi.mpk.chessandroid.di.component.AppComponent;
import mobi.mpk.chessandroid.di.component.DaggerAppComponent;
import mobi.mpk.chessandroid.di.module.ViewModule;

public class App extends Application{

    private SharedPreferences preferences;

    private static AppComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .viewModule(new ViewModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }

}
