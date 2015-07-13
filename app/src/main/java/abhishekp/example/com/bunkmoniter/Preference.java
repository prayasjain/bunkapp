package abhishekp.example.com.bunkmoniter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Preference  extends Activity implements AdapterView.OnItemClickListener {

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
