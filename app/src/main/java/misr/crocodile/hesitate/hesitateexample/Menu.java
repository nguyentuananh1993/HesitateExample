package misr.crocodile.hesitate.hesitateexample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by misrc_000 on 1/12/15.
 */
public class Menu extends ListActivity {
    String classes[] = {"startingPoint", "TextPlay","Email","example3","example4","example5","example6"};
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            Class ourClass = Class.forName("misr.crocodile.hesitate.hesitateexample."+cheese );
            Intent ourIntent = new Intent(Menu.this,ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
    }
}
