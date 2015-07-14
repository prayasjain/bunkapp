package abhishekp.example.com.bunkmoniter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Preference  extends Activity implements AdapterView.OnItemClickListener {

    ListView lv;
    String topicname;
    String[] names;
    ArrayList<String> topics ;
    SharedPreferences sp ;
    int cnt ;
    public static String folder = "mytopics";
    public static String topiccount = "TopicCount" ;
    public static String topickey = "TopicKey" ;
    Bundle bun;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topicname);

        topics.clear();
        sp=getSharedPreferences(folder,0) ;
        cnt = sp.getInt(topiccount,0) ;
        for(int i=0 ;i<cnt;i++){
            topics.add(sp.getString(topickey+(i+1)," ")) ;
        }



        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter adap = new ArrayAdapter<String>(Preference.this ,
                R.layout.topic_item,R.id.tvtopicitem,topics) ;
        lv.setAdapter(adap);
        lv.setOnItemClickListener(this);
        names = getResources().getStringArray(R.array.list);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        topicname = topics.get(position);
        bun = new Bundle();
        i = new Intent();
        bun.putString("nameoftopic", topicname);
        i.putExtras( bun);
        setResult(RESULT_OK, i);
        finish() ;
    }
}
