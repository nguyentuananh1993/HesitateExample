package misr.crocodile.hesitate.hesitateexample;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by misrc_000 on 1/29/15.
 */
public class GFX extends Activity{
    MyBringBack ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourView = new MyBringBack(this);
        setContentView(ourView);
    }
}
