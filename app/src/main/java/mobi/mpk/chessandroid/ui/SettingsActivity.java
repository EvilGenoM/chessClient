package mobi.mpk.chessandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.ui.settings.LanguageSettingsActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {

                if(position == 0) {

                    Intent intent = new Intent(SettingsActivity.this, LanguageSettingsActivity.class);
                    startActivity(intent);
                    
                } else if (position == 1) {

                    Intent intent = new Intent(SettingsActivity.this, GameSettingsActivity.class);
                    startActivity(intent);

                }

            }

        };
        
    }

}
