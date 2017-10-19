package mobi.mpk.chessandroid.ui.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;

import mobi.mpk.chessandroid.R;

public class PreferenceBoard extends Preference {

    public PreferenceBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWidgetLayoutResource(R.layout.preference_board);

    }

}
