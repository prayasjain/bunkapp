package abhishekp.example.com.bunkmoniter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by PRAYAS2 on 14-07-2015.
 */
public class AddTopic extends Activity implements View.OnClickListener {
    Button b ;
    EditText et ;
    String s ;
    int count ;
    SharedPreferences topicname;
    String topicname_pref = "topicname";
    String topicname_count_key = "topicname_count";
    String topicname_unique_key = "topicname";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject);
        setTitle("Name of Subject") ;
        b=(Button)findViewById(R.id.bttsubmit1);
        et=(EditText)findViewById(R.id.etaddtt1) ;
        b.setOnClickListener(this) ;

        topicname = getSharedPreferences(topicname_pref, 0);
        count = topicname.getInt(topicname_count_key, 0) ;

    }







    @Override
    public void onClick(View v) {
        if(v.getId()==b.getId())
        {
            s = et.getText().toString() ;
            if(!s.matches("^[ ]+$")) {
                SharedPreferences.Editor editor ;
                editor= topicname.edit();
                editor.putString(topicname_unique_key+count, s);
                count++ ;
                editor.putInt(topicname_count_key, count);
                editor.commit();
                Intent i = new Intent(AddTopic.this,Preference.class);
                setResult(RESULT_OK, i);
                finish();



            }
        }

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
