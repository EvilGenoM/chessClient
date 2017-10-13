package mobi.mpk.chessandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mobi.mpk.chessandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void onClickStartGame(View view){

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }

}
