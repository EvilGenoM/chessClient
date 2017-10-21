package mobi.mpk.chessandroid.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Inject
    Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);

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

        boolean volume = preferences.getBoolean("status_sounds", false);
        settings.setVolume(volume);


    }

    public void onClickSettings(View view){

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

}
