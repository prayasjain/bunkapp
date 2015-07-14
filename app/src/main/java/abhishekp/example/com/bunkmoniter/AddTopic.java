package abhishekp.example.com.bunkmoniter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by PRAYAS2 on 14-07-2015.
 */
public class AddTopic extends Activity implements View.OnClickListener {
    EditText et ;
    Button sub ;
    SharedPreferences memory;
    int count ;
    public static String folder = "mytopics";
    public static String topiccount = "TopicCount" ;
    public static String topickey = "TopicKey" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Add New Subject");
        sub = (Button)findViewById(R.id.bttsubmit);
        et=(EditText)findViewById(R.id.etaddtt) ;
        sub.setOnClickListener(this);
        memory=getSharedPreferences(folder,0) ;

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==sub.getId()){
            String s = et.getText().toString() ;
            if(s==" ")
            {
                return;
            }
            count = memory.getInt(topiccount,0) ;
            SharedPreferences.Editor editor ;
            editor =memory.edit() ;

            count ++ ;
             editor.putString(topickey+count,s) ;
            editor.putInt(topiccount,count) ;
            editor.commit() ;
            finish();
        }

    }
}
