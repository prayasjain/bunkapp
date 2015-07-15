package abhishekp.example.com.bunkmoniter;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Preference  extends ListActivity {
    ArrayList<String> topiclist = new ArrayList<String>();
    SharedPreferences topicname;
    String topicname_pref = "topicname";
    String topicname_count_key = "topicname_count";
    String topicname_unique_key = "topicname";

    String subjectname;
    Bundle bun;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        topiclist = new ArrayList<String>();

        topicname = getSharedPreferences(topicname_pref, 0);
        int count = topicname.getInt(topicname_count_key, 0);
        for (int i = 0; i < count; i++) {
            topiclist.add(i, topicname.getString(topicname_unique_key + i,
                    "Save one First!! "));

        }
        topiclist.add("Add a New Subject");
        setListAdapter(new ArrayAdapter<String>(Preference.this,
                android.R.layout.simple_list_item_1, topiclist));
        sendTimetable();

    }

    public ArrayList<String> sendTimetable() {
        return topiclist;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        Intent p = new Intent(Preference.this,AddTopic.class);
        if(position==(topiclist.size()-1)){
            startActivityForResult(p, 0);
        }
        else {
            subjectname = topiclist.get(position);
            bun = new Bundle();
            i = new Intent();
            bun.putString("nameoftopic", subjectname);
            i.putExtras( bun);
            setResult(RESULT_OK, i);
            finish() ;
        }

    }

}

        
        /*extends Activity implements AdapterView.OnItemClickListener {

    ListView lv;
    String topicname;
    String[] names;
    Bundle bun;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topicname);
        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(this);
        names = getResources().getStringArray(R.array.list);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        topicname = names[position];
        bun = new Bundle();
        i = new Intent();
        bun.putString("nameoftopic", topicname);
        i.putExtras( bun);
        setResult(RESULT_OK, i);
        finish() ;
    }
}
*/