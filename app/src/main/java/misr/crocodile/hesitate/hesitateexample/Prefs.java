package misr.crocodile.hesitate.hesitateexample;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by misrc_000 on 1/20/15.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
