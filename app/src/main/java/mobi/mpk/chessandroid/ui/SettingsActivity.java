package mobi.mpk.chessandroid.ui;

import android.os.Bundle;
import android.preference.PreferenceScreen;

import mobi.mpk.chessandroid.R;

public class SettingsActivity extends android.preference.PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);

        PreferenceScreen preference = (PreferenceScreen) findPreference("setting_pieces");
        
    }

}
