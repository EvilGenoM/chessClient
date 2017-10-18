package mobi.mpk.chessandroid.ui;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import mobi.mpk.chessandroid.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
        
    }

}
