package mobi.mpk.chessandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getComponent().inject(this);

        setContentView(R.layout.activity_game);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_game);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = new ActionBar(this, toolbar);
    }

}
