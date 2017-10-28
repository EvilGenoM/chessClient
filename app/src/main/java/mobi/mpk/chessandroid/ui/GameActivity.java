package mobi.mpk.chessandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.controller.GameController;

public class GameActivity extends AppCompatActivity {

    @Inject
    GameController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getComponent().inject(this);

        setContentView(R.layout.activity_game);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_game);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = new ActionBar(this, toolbar);

        TextView textEnemy = (TextView) findViewById(R.id.text_enemy_name);
        TextView textUser = (TextView) findViewById(R.id.text_name_user);

        textEnemy.setText(controller.getNameEnemy());
        textUser.setText(controller.getUsername());

    }

}
