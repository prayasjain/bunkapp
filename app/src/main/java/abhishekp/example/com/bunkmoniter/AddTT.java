package abhishekp.example.com.bunkmoniter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


    public class AddTT extends Activity implements View.OnClickListener {
    Button b ;
    EditText et ;
    String s ;
    int count ;
    SharedPreferences timetables;
    String timetables_pref = "timetables";
    String timetable_count_key = "timetable_count";
    String timetable_unique_key = "timetable";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Name of Timetable") ;
        b=(Button)findViewById(R.id.bttsubmit);
        et=(EditText)findViewById(R.id.etaddtt) ;
        b.setOnClickListener(this) ;

        timetables = getSharedPreferences(timetables_pref, 0);
        count = timetables.getInt(timetable_count_key, 0) ;

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(v.getId()==b.getId())
        {
            s = et.getText().toString() ;
            if(!s.matches("^[ ]+$")) {
                SharedPreferences.Editor editor ;
                editor= timetables.edit();
                editor.putString(timetable_unique_key+count, s);
                count++ ;
                editor.putInt(timetable_count_key, count);
                editor.commit();
                Intent i = new Intent(AddTT.this,MainActivity.class);
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
