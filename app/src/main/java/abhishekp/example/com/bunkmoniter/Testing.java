package abhishekp.example.com.bunkmoniter;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Testing extends Activity implements View.OnClickListener {
    private TextView text[][] = new TextView[7][8];
    Intent p;
    Bundle b;
    String name;
    SharedPreferences memory;
    public static String folder = "myfolder";
    String savingstring;
    SharedPreferences.Editor editing;
    String gotdata;
    private DrawerLayout nav_draw;
    private ListView temp_nav_list;
    private String[] lv_string;
    private ActionBarDrawerToggle abdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetableentry);
        initialize();
        memory = getSharedPreferences(folder, 0);

        loadingdata();
        disableclick();
        /**Floating Action Button **/
        final FloatingActionsMenu fam = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        final FloatingActionButton button_addtopic = (FloatingActionButton) findViewById(R.id.button_addtopic);
        button_addtopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_addtopic.setTitle("Add Topic clicked");
            }
        });

        final FloatingActionButton button_ViewTopics = (FloatingActionButton) findViewById(R.id.button_ViewTopics);
        button_ViewTopics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_ViewTopics.setTitle("View Topics clicked");

            }
        });

        final FloatingActionButton button_editTT = (FloatingActionButton) findViewById(R.id.button_editTT);
        button_editTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_editTT.setTitle("Edit TT clicked");
                enableclick();
                fam.collapse();
            }
        });

        final FloatingActionButton button_Attendance = (FloatingActionButton) findViewById(R.id.button_Attendance);
        button_Attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_Attendance.setTitle("Attendance  clicked");

            }
        });


        /**Navigation Drwaer**/

        nav_draw = (DrawerLayout) findViewById(R.id.drawerlayout);
        temp_nav_list = (ListView) findViewById(R.id.id_lv_navDrawer);
        lv_string = getResources().getStringArray(R.array.options);
        abdt = new ActionBarDrawerToggle(Testing.this,nav_draw,0,0);
        temp_nav_list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lv_string));
        temp_nav_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent j = new Intent(Testing.this,MainActivity.class);
                    startActivity(j);

                }
                if(position==1){
                    enableclick();
                }
                Toast.makeText(getBaseContext(), lv_string[position] + " clicked", Toast.LENGTH_SHORT).show();
                titleset(lv_string[position]);
            }
        });
        nav_draw.setDrawerListener(abdt);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        abdt.syncState();




/*
        NavigationDrawer fr = new NavigationDrawer();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.timetableentry,fr,"text");
        ft.commit();*/
    }

    private void enableclick(){
        text[1][1].setClickable(true);
        text[2][1].setClickable(true);
        text[3][1].setClickable(true);
        text[4][1].setClickable(true);
        text[5][1].setClickable(true);
        text[6][1].setClickable(true);
        text[1][2].setClickable(true);
        text[2][2].setClickable(true);
        text[3][2].setClickable(true);
        text[4][2].setClickable(true);
        text[5][2].setClickable(true);
        text[6][2].setClickable(true);
        text[1][3].setClickable(true);
        text[2][3].setClickable(true);
        text[3][3].setClickable(true);
        text[4][3].setClickable(true);
        text[5][3].setClickable(true);
        text[6][3].setClickable(true);
        text[1][4].setClickable(true);
        text[2][4].setClickable(true);
        text[3][4].setClickable(true);
        text[4][4].setClickable(true);
        text[5][4].setClickable(true);
        text[6][4].setClickable(true);
        text[1][5].setClickable(true);
        text[2][5].setClickable(true);
        text[3][5].setClickable(true);
        text[4][5].setClickable(true);
        text[5][5].setClickable(true);
        text[6][5].setClickable(true);
        text[1][6].setClickable(true);
        text[2][6].setClickable(true);
        text[3][6].setClickable(true);
        text[4][6].setClickable(true);
        text[5][6].setClickable(true);
        text[6][6].setClickable(true);
        text[1][7].setClickable(true);
        text[2][7].setClickable(true);
        text[3][7].setClickable(true);
        text[4][7].setClickable(true);
        text[5][7].setClickable(true);
        text[6][7].setClickable(true);
    }

    private void disableclick() {
        text[1][1].setClickable(false);
        text[2][1].setClickable(false);
        text[3][1].setClickable(false);
        text[4][1].setClickable(false);
        text[5][1].setClickable(false);
        text[6][1].setClickable(false);
        text[1][2].setClickable(false);
        text[2][2].setClickable(false);
        text[3][2].setClickable(false);
        text[4][2].setClickable(false);
        text[5][2].setClickable(false);
        text[6][2].setClickable(false);
        text[1][3].setClickable(false);
        text[2][3].setClickable(false);
        text[3][3].setClickable(false);
        text[4][3].setClickable(false);
        text[5][3].setClickable(false);
        text[6][3].setClickable(false);
        text[1][4].setClickable(false);
        text[2][4].setClickable(false);
        text[3][4].setClickable(false);
        text[4][4].setClickable(false);
        text[5][4].setClickable(false);
        text[6][4].setClickable(false);
        text[1][5].setClickable(false);
        text[2][5].setClickable(false);
        text[3][5].setClickable(false);
        text[4][5].setClickable(false);
        text[5][5].setClickable(false);
        text[6][5].setClickable(false);
        text[1][6].setClickable(false);
        text[2][6].setClickable(false);
        text[3][6].setClickable(false);
        text[4][6].setClickable(false);
        text[5][6].setClickable(false);
        text[6][6].setClickable(false);
        text[1][7].setClickable(false);
        text[2][7].setClickable(false);
        text[3][7].setClickable(false);
        text[4][7].setClickable(false);
        text[5][7].setClickable(false);
        text[6][7].setClickable(false);


    }

    private void loadingdata() {

        memory = getSharedPreferences(folder, 0);
        gotdata = memory.getString("11", "Empty");
        text[1][1].setText(gotdata);
        gotdata = memory.getString("21", "Empty");
        text[2][1].setText(gotdata);
        gotdata = memory.getString("31", "Empty");
        text[3][1].setText(gotdata);
        gotdata = memory.getString("41", "Empty");
        text[4][1].setText(gotdata);
        gotdata = memory.getString("51", "Empty");
        text[5][1].setText(gotdata);
        gotdata = memory.getString("61", "Empty");
        text[6][1].setText(gotdata);
        gotdata = memory.getString("12", "Empty");
        text[1][2].setText(gotdata);
        gotdata = memory.getString("22", "Empty");
        text[2][2].setText(gotdata);
        gotdata = memory.getString("32", "Empty");
        text[3][2].setText(gotdata);
        gotdata = memory.getString("42", "Empty");
        text[4][2].setText(gotdata);
        gotdata = memory.getString("52", "Empty");
        text[5][2].setText(gotdata);
        gotdata = memory.getString("62", "Empty");
        text[6][2].setText(gotdata);
        gotdata = memory.getString("13", "Empty");
        text[1][3].setText(gotdata);
        gotdata = memory.getString("23", "Empty");
        text[2][3].setText(gotdata);
        gotdata = memory.getString("33", "Empty");
        text[3][3].setText(gotdata);
        gotdata = memory.getString("43", "Empty");
        text[4][3].setText(gotdata);
        gotdata = memory.getString("53", "Empty");
        text[5][3].setText(gotdata);
        gotdata = memory.getString("63", "Empty");
        text[6][3].setText(gotdata);
        gotdata = memory.getString("14", "Empty");
        text[1][4].setText(gotdata);
        gotdata = memory.getString("24", "Empty");
        text[2][4].setText(gotdata);
        gotdata = memory.getString("34", "Empty");
        text[3][4].setText(gotdata);
        gotdata = memory.getString("44", "Empty");
        text[4][4].setText(gotdata);
        gotdata = memory.getString("54", "Empty");
        text[5][4].setText(gotdata);
        gotdata = memory.getString("64", "Empty");
        text[6][4].setText(gotdata);
        gotdata = memory.getString("15", "Empty");
        text[1][5].setText(gotdata);
        gotdata = memory.getString("25", "Empty");
        text[2][5].setText(gotdata);
        gotdata = memory.getString("35", "Empty");
        text[3][5].setText(gotdata);
        gotdata = memory.getString("45", "Empty");
        text[4][5].setText(gotdata);
        gotdata = memory.getString("55", "Empty");
        text[5][5].setText(gotdata);
        gotdata = memory.getString("65", "Empty");
        text[6][5].setText(gotdata);
        gotdata = memory.getString("16", "Empty");
        text[1][6].setText(gotdata);
        gotdata = memory.getString("26", "Empty");
        text[2][6].setText(gotdata);
        gotdata = memory.getString("36", "Empty");
        text[3][6].setText(gotdata);
        gotdata = memory.getString("46", "Empty");
        text[4][6].setText(gotdata);
        gotdata = memory.getString("56", "Empty");
        text[5][6].setText(gotdata);
        gotdata = memory.getString("66", "Empty");
        text[6][6].setText(gotdata);
        gotdata = memory.getString("17", "Empty");
        text[1][7].setText(gotdata);
        gotdata = memory.getString("27", "Empty");
        text[2][7].setText(gotdata);
        gotdata = memory.getString("37", "Empty");
        text[3][7].setText(gotdata);
        gotdata = memory.getString("47", "Empty");
        text[4][7].setText(gotdata);
        gotdata = memory.getString("57", "Empty");
        text[5][7].setText(gotdata);
        gotdata = memory.getString("67", "Empty");
        text[6][7].setText(gotdata);
     textalign() ;

    }
    private void textalign(){
        int x,m ;

        for(int i=1;i<=7;i++){
            m=0 ;

            for(int j=0;j<=6;j++){
                text[j][i].measure(0,0);
                x=text[j][i].getMeasuredWidth() ;
                if(x>m)
                    m=x ;
            }
            for(int j=0;j<=6;j++){
                text[j][i].setWidth(m);
            }
        }



}

    private void initialize() {

        text[0][1] = (TextView) findViewById(R.id.tv01);
        text[0][2] = (TextView) findViewById(R.id.tv02);
        text[0][3] = (TextView) findViewById(R.id.tv03);
        text[0][4] = (TextView) findViewById(R.id.tv04);
        text[0][5] = (TextView) findViewById(R.id.tv05);
        text[0][6] = (TextView) findViewById(R.id.tv06);
        text[0][7] = (TextView) findViewById(R.id.tv07);



        text[1][1] = (TextView) findViewById(R.id.tv11);
        text[2][1] = (TextView) findViewById(R.id.tv21);
        text[3][1] = (TextView) findViewById(R.id.tv31);
        text[4][1] = (TextView) findViewById(R.id.tv41);
        text[5][1] = (TextView) findViewById(R.id.tv51);
        text[6][1] = (TextView) findViewById(R.id.tv61);
        text[1][2] = (TextView) findViewById(R.id.tv12);
        text[2][2] = (TextView) findViewById(R.id.tv22);
        text[3][2] = (TextView) findViewById(R.id.tv32);
        text[4][2] = (TextView) findViewById(R.id.tv42);
        text[5][2] = (TextView) findViewById(R.id.tv52);
        text[6][2] = (TextView) findViewById(R.id.tv62);
        text[1][3] = (TextView) findViewById(R.id.tv13);
        text[2][3] = (TextView) findViewById(R.id.tv23);
        text[3][3] = (TextView) findViewById(R.id.tv33);
        text[4][3] = (TextView) findViewById(R.id.tv43);
        text[5][3] = (TextView) findViewById(R.id.tv53);
        text[6][3] = (TextView) findViewById(R.id.tv63);
        text[1][4] = (TextView) findViewById(R.id.tv14);
        text[2][4] = (TextView) findViewById(R.id.tv24);
        text[3][4] = (TextView) findViewById(R.id.tv34);
        text[4][4] = (TextView) findViewById(R.id.tv44);
        text[5][4] = (TextView) findViewById(R.id.tv54);
        text[6][4] = (TextView) findViewById(R.id.tv64);
        text[1][5] = (TextView) findViewById(R.id.tv15);
        text[2][5] = (TextView) findViewById(R.id.tv25);
        text[3][5] = (TextView) findViewById(R.id.tv35);
        text[4][5] = (TextView) findViewById(R.id.tv45);
        text[5][5] = (TextView) findViewById(R.id.tv55);
        text[6][5] = (TextView) findViewById(R.id.tv65);
        text[1][6] = (TextView) findViewById(R.id.tv16);
        text[2][6] = (TextView) findViewById(R.id.tv26);
        text[3][6] = (TextView) findViewById(R.id.tv36);
        text[4][6] = (TextView) findViewById(R.id.tv46);
        text[5][6] = (TextView) findViewById(R.id.tv56);
        text[6][6] = (TextView) findViewById(R.id.tv66);
        text[1][7] = (TextView) findViewById(R.id.tv17);
        text[2][7] = (TextView) findViewById(R.id.tv27);
        text[3][7] = (TextView) findViewById(R.id.tv37);
        text[4][7] = (TextView) findViewById(R.id.tv47);
        text[5][7] = (TextView) findViewById(R.id.tv57);
        text[6][7] = (TextView) findViewById(R.id.tv67);


        text[1][1].setOnClickListener(this);
        text[2][1].setOnClickListener(this);
        text[3][1].setOnClickListener(this);
        text[4][1].setOnClickListener(this);
        text[5][1].setOnClickListener(this);
        text[6][1].setOnClickListener(this);
        text[1][2].setOnClickListener(this);
        text[2][2].setOnClickListener(this);
        text[3][2].setOnClickListener(this);
        text[4][2].setOnClickListener(this);
        text[5][2].setOnClickListener(this);
        text[6][2].setOnClickListener(this);
        text[1][3].setOnClickListener(this);
        text[2][3].setOnClickListener(this);
        text[3][3].setOnClickListener(this);
        text[4][3].setOnClickListener(this);
        text[5][3].setOnClickListener(this);
        text[6][3].setOnClickListener(this);
        text[1][4].setOnClickListener(this);
        text[2][4].setOnClickListener(this);
        text[3][4].setOnClickListener(this);
        text[4][4].setOnClickListener(this);
        text[5][4].setOnClickListener(this);
        text[6][4].setOnClickListener(this);
        text[1][5].setOnClickListener(this);
        text[2][5].setOnClickListener(this);
        text[3][5].setOnClickListener(this);
        text[4][5].setOnClickListener(this);
        text[5][5].setOnClickListener(this);
        text[6][5].setOnClickListener(this);
        text[1][6].setOnClickListener(this);
        text[2][6].setOnClickListener(this);
        text[3][6].setOnClickListener(this);
        text[4][6].setOnClickListener(this);
        text[5][6].setOnClickListener(this);
        text[6][6].setOnClickListener(this);
        text[1][7].setOnClickListener(this);
        text[2][7].setOnClickListener(this);
        text[3][7].setOnClickListener(this);
        text[4][7].setOnClickListener(this);
        text[5][7].setOnClickListener(this);
        text[6][7].setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv11:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p, 11);

                break;
            case R.id.tv21:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,21);
                break;
            case R.id.tv31:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,31);
                break;
            case R.id.tv41:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,41);
                break;
            case R.id.tv51:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,51);
                break;
            case R.id.tv61:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,61);
                break;
            case R.id.tv12:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,12);
                break;
            case R.id.tv22:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,22);
                break;
            case R.id.tv32:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,32);
                break;
            case R.id.tv42:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,42);
                break;
            case R.id.tv52:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,52);
                break;
            case R.id.tv62:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,62);
                break;
            case R.id.tv13:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,13);
                break;
            case R.id.tv23:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,23);
                break;
            case R.id.tv33:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,33);
                break;
            case R.id.tv43:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,43);
                break;
            case R.id.tv53:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,53);
                break;
            case R.id.tv63:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,63);
                break;
            case R.id.tv14:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,14);
                break;
            case R.id.tv24:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,24);
                break;
            case R.id.tv34:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,34);
                break;
            case R.id.tv44:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,44);
                break;
            case R.id.tv54:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,54);
                break;
            case R.id.tv64:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,64);
                break;
            case R.id.tv15:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,15);
                break;
            case R.id.tv25:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,25);
                break;
            case R.id.tv35:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,35);
                break;
            case R.id.tv45:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,45);
                break;
            case R.id.tv55:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,55);
                break;
            case R.id.tv65:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,65);
                break;
            case R.id.tv16:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,16);
                break;
            case R.id.tv26:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,26);
                break;
            case R.id.tv36:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,36);
                break;
            case R.id.tv46:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,46);
                break;
            case R.id.tv56:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,56);
                break;
            case R.id.tv66:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,66);
                break;
            case R.id.tv17:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,17);
                break;
            case R.id.tv27:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,27);
                break;
            case R.id.tv37:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,37);
                break;
            case R.id.tv47:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,47);
                break;
            case R.id.tv57:
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,57);
                break;
            case R.id.tv67  :
                p = new Intent(Testing.this,Preference.class);
                startActivityForResult(p,67);
                break;


        }

        textalign();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch(requestCode){
                case 11:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[1][1].setText(name);
                    savingstring = text[1][1].getText().toString();
                    editing = memory.edit();
                    editing.putString("11", savingstring);
                    editing.commit();
                    break;
                case 21:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[2][1].setText(name);
                    savingstring = text[2][1].getText().toString();
                    editing = memory.edit();
                    editing.putString("21", savingstring);
                    editing.commit();
                    break;
                case 31:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[3][1].setText(name);
                    savingstring = text[3][1].getText().toString();
                    editing = memory.edit();
                    editing.putString("31", savingstring);
                    editing.commit();
                    break;
                case 41:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[4][1].setText(name);
                    savingstring = text[4][1].getText().toString();
                    editing = memory.edit();
                    editing.putString("41", savingstring);
                    editing.commit();
                    break;
                case 51:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[5][1].setText(name);
                    savingstring = text[5][1].getText().toString();
                    editing = memory.edit();
                    editing.putString("51", savingstring);
                    editing.commit();
                    break;
                case 61:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[6][1].setText(name);
                    savingstring = text[6][1].getText().toString();
                    editing = memory.edit();
                    editing.putString("61", savingstring);
                    editing.commit();
                    break;
                case 12:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[1][2].setText(name);
                    savingstring = text[1][2].getText().toString();
                    editing = memory.edit();
                    editing.putString("12", savingstring);
                    editing.commit();
                    break;
                case 22:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[2][2].setText(name);
                    savingstring = text[2][2].getText().toString();
                    editing = memory.edit();
                    editing.putString("22", savingstring);
                    editing.commit();
                    break;
                case 32:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[3][2].setText(name);
                    savingstring = text[3][2].getText().toString();
                    editing = memory.edit();
                    editing.putString("32", savingstring);
                    editing.commit();
                    break;
                case 42:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[4][2].setText(name);
                    savingstring = text[4][2].getText().toString();
                    editing = memory.edit();
                    editing.putString("42", savingstring);
                    editing.commit();
                    break;
                case 52:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[5][2].setText(name);
                    savingstring = text[5][2].getText().toString();
                    editing = memory.edit();
                    editing.putString("52", savingstring);
                    editing.commit();
                    break;
                case 62:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[6][2].setText(name);
                    savingstring = text[6][2].getText().toString();
                    editing = memory.edit();
                    editing.putString("62", savingstring);
                    editing.commit();
                    break;
                case 13:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[1][3].setText(name);
                    savingstring = text[1][3].getText().toString();
                    editing = memory.edit();
                    editing.putString("13", savingstring);
                    editing.commit();
                    break;
                case 23:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[2][3].setText(name);
                    savingstring = text[2][3].getText().toString();
                    editing = memory.edit();
                    editing.putString("23", savingstring);
                    editing.commit();
                    break;
                case 33:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[3][3].setText(name);
                    savingstring = text[3][3].getText().toString();
                    editing = memory.edit();
                    editing.putString("33", savingstring);
                    editing.commit();
                    break;
                case 43:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[4][3].setText(name);
                    savingstring = text[4][3].getText().toString();
                    editing = memory.edit();
                    editing.putString("43", savingstring);
                    editing.commit();
                    break;
                case 53:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[5][3].setText(name);
                    savingstring = text[5][3].getText().toString();
                    editing = memory.edit();
                    editing.putString("53", savingstring);
                    editing.commit();

                    break;
                case 63:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[6][3].setText(name);
                    savingstring = text[6][3].getText().toString();
                    editing = memory.edit();
                    editing.putString("63", savingstring);
                    editing.commit();
                    break;
                case 14:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[1][4].setText(name);
                    savingstring = text[1][4].getText().toString();
                    editing = memory.edit();
                    editing.putString("14", savingstring);
                    editing.commit();
                    break;
                case 24:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[2][4].setText(name);
                    savingstring = text[2][4].getText().toString();
                    editing = memory.edit();
                    editing.putString("24", savingstring);
                    editing.commit();
                    break;
                case 34:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[3][4].setText(name);
                    savingstring = text[3][4].getText().toString();
                    editing = memory.edit();
                    editing.putString("34", savingstring);
                    editing.commit();
                    break;
                case 44:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[4][4].setText(name);
                    savingstring = text[4][4].getText().toString();
                    editing = memory.edit();
                    editing.putString("44", savingstring);
                    editing.commit();
                    break;
                case 54:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[5][4].setText(name);
                    savingstring = text[5][4].getText().toString();
                    editing = memory.edit();
                    editing.putString("54", savingstring);
                    editing.commit();
                    break;
                case 64:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[6][4].setText(name);
                    savingstring = text[6][4].getText().toString();
                    editing = memory.edit();
                    editing.putString("64", savingstring);
                    editing.commit();
                    break;
                case 15:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[1][5].setText(name);
                    savingstring = text[1][5].getText().toString();
                    editing = memory.edit();
                    editing.putString("15", savingstring);
                    editing.commit();
                    break;
                case 25:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[2][5].setText(name);
                    savingstring = text[2][5].getText().toString();
                    editing = memory.edit();
                    editing.putString("25", savingstring);
                    editing.commit();
                    break;
                case 35:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[3][5].setText(name);
                    savingstring = text[3][5].getText().toString();
                    editing = memory.edit();
                    editing.putString("35", savingstring);
                    editing.commit();
                    break;
                case 45:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[4][5].setText(name);
                    savingstring = text[4][5].getText().toString();
                    editing = memory.edit();
                    editing.putString("45", savingstring);
                    editing.commit();
                    break;
                case 55:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[5][5].setText(name);
                    savingstring = text[5][5].getText().toString();
                    editing = memory.edit();
                    editing.putString("55", savingstring);
                    editing.commit();
                    break;
                case 65:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[6][5].setText(name);
                    savingstring = text[6][5].getText().toString();
                    editing = memory.edit();
                    editing.putString("65", savingstring);
                    editing.commit();
                    break;
                case 16:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[1][6].setText(name);
                    savingstring = text[1][6].getText().toString();
                    editing = memory.edit();
                    editing.putString("16", savingstring);
                    editing.commit();
                    break;
                case 26:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[2][6].setText(name);
                    savingstring = text[2][6].getText().toString();
                    editing = memory.edit();
                    editing.putString("26", savingstring);
                    editing.commit();
                    break;
                case 36:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[3][6].setText(name);
                    savingstring = text[3][6].getText().toString();
                    editing = memory.edit();
                    editing.putString("36", savingstring);
                    editing.commit();
                    break;
                case 46:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[4][6].setText(name);
                    savingstring = text[4][6].getText().toString();
                    editing = memory.edit();
                    editing.putString("46", savingstring);
                    editing.commit();
                    break;
                case 56:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[5][6].setText(name);
                    savingstring = text[5][6].getText().toString();
                    editing = memory.edit();
                    editing.putString("56", savingstring);
                    editing.commit();
                    break;
                case 66:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[6][6].setText(name);
                    savingstring = text[6][6].getText().toString();
                    editing = memory.edit();
                    editing.putString("66", savingstring);
                    editing.commit();
                    break;
                case 17:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[1][7].setText(name);
                    savingstring = text[1][7].getText().toString();
                    editing = memory.edit();
                    editing.putString("17", savingstring);
                    editing.commit();
                    break;
                case 27:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[2][7].setText(name);
                    savingstring = text[2][7].getText().toString();
                    editing = memory.edit();
                    editing.putString("27", savingstring);
                    editing.commit();
                    break;
                case 37:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[3][7].setText(name);
                    savingstring = text[3][7].getText().toString();
                    editing = memory.edit();
                    editing.putString("37", savingstring);
                    editing.commit();
                    break;
                case 47:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[4][7].setText(name);
                    savingstring = text[4][7].getText().toString();
                    editing = memory.edit();
                    editing.putString("47", savingstring);
                    editing.commit();
                    break;
                case 57:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[5][7].setText(name);
                    savingstring = text[5][7].getText().toString();
                    editing = memory.edit();
                    editing.putString("57", savingstring);
                    editing.commit();
                    break;
                case 67:
                    b = data.getExtras();
                    name = b.getString("nameoftopic");
                    text[6][7].setText(name);
                    savingstring = text[6][7].getText().toString();
                    editing = memory.edit();
                    editing.putString("67", savingstring);
                    editing.commit();
                    break;

            }





        }
    }

    public void titleset(String title){
        getActionBar().setTitle(title);
    }
}
