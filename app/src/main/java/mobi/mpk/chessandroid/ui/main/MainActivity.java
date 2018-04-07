package mobi.mpk.chessandroid.ui.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.net.WebSocketConnection;
import mobi.mpk.chessandroid.presenter.lobby.in.LobbyPresenterIn;
import mobi.mpk.chessandroid.settings.Settings;
import mobi.mpk.chessandroid.ui.actionbar.ActionBar;
import mobi.mpk.chessandroid.ui.setting.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Inject
    WebSocketConnection connection;
    @Inject
    Settings settings;
    @Inject
    LobbyPresenterIn lobbyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);

        lobbyPresenter.setActivity(this);

        showToolbar();

        if(!settings.getConnection()) {

            Toast toast = Toast.makeText(getApplicationContext(), "Ошибка подключения", Toast.LENGTH_SHORT);
            toast.show();

        } else {

            Toast toast = Toast.makeText(getApplicationContext(), "Успешное подключение", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

    private void showToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = new ActionBar(this, toolbar);

    }

    @Override
    public void onStart(){

        super.onStart();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean dragAndDrop = preferences.getBoolean("drag_and_drop", false);
        settings.setDragAndDrop(dragAndDrop);

        boolean coordinateBoard = preferences.getBoolean("board_coordinates", false);
        settings.setCoordinateBoard(coordinateBoard);

        String username = preferences.getString("net_username", null);
        settings.setUsername(username);

        String address = preferences.getString("net_address", null);
        settings.setAddress(address);
        connection.connection();;

        boolean volume = preferences.getBoolean("status_sounds", false);
        settings.setVolume(volume);

    }

    public void onClickSettings(View view){

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

}
