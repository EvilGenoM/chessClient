package mobi.mpk.chessandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.di.component.AppComponent;
import mobi.mpk.chessandroid.di.component.DaggerAppComponent;
import mobi.mpk.chessandroid.di.module.ViewModule;

public class MainActivity extends AppCompatActivity {

    private static AppComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        component = buildComponent();

        setContentView(R.layout.activity_main);

    }

    public void onClickStartGame(View view){

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

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
