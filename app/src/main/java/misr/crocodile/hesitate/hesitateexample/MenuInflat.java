package misr.crocodile.hesitate.hesitateexample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by misrc_000 on 1/12/15.
 */
public class MenuInflat extends ListActivity {
    String classes[] = {"startingPoint", "TextPlay", "Email", "Camera", "Data", "GFX", "GFXSurface"};

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            Class ourClass = Class.forName("misr.crocodile.hesitate.hesitateexample." + cheese);
            Intent ourIntent = new Intent(MenuInflat.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//full-screen command
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setListAdapter(new ArrayAdapter<String>(MenuInflat.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.aboutUs:
                Intent i = new Intent("main.ABOUTUS");
                startActivity(i);
                break;
            case R.id.preferences:
                Intent ei = new Intent("main.PREFS");
                startActivity(ei);
                break;
            case R.id.exit:
                finish();
                break;

        }
        return true;
    }
}
