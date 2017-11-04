package mobi.mpk.chessandroid.ui.setting;

import android.os.Bundle;

import mobi.mpk.chessandroid.R;

public class SettingsActivity extends android.preference.PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);

    }

}
