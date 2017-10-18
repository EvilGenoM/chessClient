package mobi.mpk.chessandroid.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import mobi.mpk.chessandroid.R;

public class SettingsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        String[] options = getResources().getStringArray(R.array.options);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_settings, R.id.list_content, options);
        setListAdapter(adapter);
        
    }

}
