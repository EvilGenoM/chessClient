package mobi.mpk.chessandroid;

import android.app.Application;

import mobi.mpk.chessandroid.di.component.AppComponent;
import mobi.mpk.chessandroid.di.component.DaggerAppComponent;
import mobi.mpk.chessandroid.di.module.ViewModule;
import mobi.mpk.chessandroid.net.Network;

public class App extends Application{

    private static AppComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        Network network = new Network("176.214.153.183");
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
