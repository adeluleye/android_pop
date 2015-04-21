package com.wizcodegroup.pop;

/**
 * Created by Lheye on 4/20/15.
 */

import android.net.Uri;
import android.widget.Toast;
import android.app.DialogFragment;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
public class MainActivity extends ActionBarActivity {
    GridView gv;
    Context context;
    public static String [] popList={"About Me","Contact Me","My Interest","My Community","My Hobbies","History","Email","Phone No","My Location"};
    public static int [] popIcons={R.drawable.about,R.drawable.mail,R.drawable.interest,R.drawable.community,R.drawable.hobby,R.drawable.history,R.drawable.mail,R.drawable.phone,R.drawable.location};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new MyAdapter(this, popList,popIcons));

        gv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                switch (position) {
                    case 0:

                        //Intent for the AboutMe Section
                        Intent aboutMe = new Intent(getApplicationContext(), RegisterActivity.class);
                        startActivity(aboutMe);
                        break;

                    case 1:
                        //Intent for the ContactMe Section
                        Intent contactMe = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(contactMe);
                        break;

                    case 2:
                        //Intent for the ContactMe Section
                        Intent myInterest = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(myInterest);
                        break;

                    case 3:
                        //Intent for the ContactMe Section
                        Intent myBackgroud = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(myBackgroud);
                        break;

                    case 4:
                        //Intent for the ContactMe Section
                        Intent favorite = new Intent(getApplicationContext(), HobbiesActivity.class);
                        startActivity(favorite);
                        break;

                    case 5:
                        //Intent for the ContactMe Section
                        Intent history = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(history);
                        break;

                    case 6:
                        //Intent for the ContactMe Section
                        sendEmail();
                        break;

                    case 7:
                        //Intent for the ContactMe Section
                        call();
                        break;

                    case 8:
                        //Intent for the ContactMe Section
                        Intent myHeart = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(myHeart);
                        break;
                    default:
                        break;
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            //finish();
            DialogFragment myFragment = new SettingsDialogFragment();
            //Fragment Manager allows me to interact with the Fragment
            myFragment.show(getFragmentManager(), "myDialog");
            return true;
        } else if (id == R.id.share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"POP");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                    "Hi friend! Kindly check out my first Android Application out in the store");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }
        return super.onOptionsItemSelected(item);
    }


    private void call() {
        String myNumber = "0541517994";


            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+myNumber));
            startActivity(callIntent);

    }

    //This method sends Email
    private void sendEmail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"abideen.adelu@meltwater.org"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Sending..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients on this device.", Toast.LENGTH_SHORT).show();
        }
    }



}
