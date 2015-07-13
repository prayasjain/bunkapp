package abhishekp.example.com.bunkmoniter;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ListActivity {
    ArrayList<String> ttlist = new ArrayList<String>();
    SharedPreferences timetables;
    String timetables_pref = "timetables";
    String timetable_count_key = "timetable_count";
    String timetable_unique_key = "timetable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        ttlist = new ArrayList<String>();

        timetables = getSharedPreferences(timetables_pref, 0);
        int count = timetables.getInt(timetable_count_key, 0);
        for (int i = 0; i < count; i++) {
            ttlist.add(i, timetables.getString(timetable_unique_key + i,
                    "Save one First!! "));

        }
        ttlist.add("Add a New Timetable");
        setListAdapter(new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, ttlist));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        Intent p = new Intent(MainActivity.this,AddTT.class);
        if(position==(ttlist.size()-1)){
            startActivityForResult(p, 0);
        }

    }

}
