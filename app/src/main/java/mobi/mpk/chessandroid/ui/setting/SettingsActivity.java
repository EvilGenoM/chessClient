package mobi.mpk.chessandroid.ui.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.net.WebSocketConnection;
import mobi.mpk.chessandroid.presenter.lobby.in.LobbyPresenterIn;
import mobi.mpk.chessandroid.settings.Settings;

public class SettingsActivity extends android.preference.PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    @Inject
    Settings settings;
    @Inject
    WebSocketConnection connection;
    @Inject
    LobbyPresenterIn lobbyPresenterIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);

        lobbyPresenterIn.setActivity(this);

        addPreferencesFromResource(R.xml.settings);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences preferences, String s) {

        boolean dragAndDrop = preferences.getBoolean("drag_and_drop", false);
        settings.setDragAndDrop(dragAndDrop);

        boolean coordinateBoard = preferences.getBoolean("board_coordinates", false);
        settings.setCoordinateBoard(coordinateBoard);

        String username = preferences.getString("net_username", null);
        settings.setUsername(username);

        String address = preferences.getString("net_address", null);
        settings.setAddress(address);
        connection.connection();

        boolean volume = preferences.getBoolean("status_sounds", false);
        settings.setVolume(volume);

        if(s.equals("net_address") && !settings.getConnection()) {

            Toast toast = Toast.makeText(getApplicationContext(), "Ошибка подключения", Toast.LENGTH_SHORT);
            toast.show();

        } else if(s.equals("net_address") && settings.getConnection()) {

            Toast toast = Toast.makeText(getApplicationContext(), "Успешное подключение", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    public static Context getContext() {
        return getContext();
    }

}
