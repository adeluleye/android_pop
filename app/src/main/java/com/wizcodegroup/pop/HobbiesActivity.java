package com.wizcodegroup.pop;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Lheye on 4/20/15.
 */
public class HobbiesActivity extends ActionBarActivity {
    private ListView hobbiesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        String[] myHobbies = {"Travelling", "Meeting People", "Coding", "Singing", "Chilling", "Reading", "Football", "Dancing"};

        //Using generic layout for each row
        //ListAdapter myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myHobbies);

        //Using custom list_row_layout
        //ListAdapter myListAdapter = new ListViewAdapter(this, R.layout.list_row_layout, R.id.myTextView, myHobbies);

        //Creating an Adapter
        ListAdapter myListAdapter = new ListViewAdapter(this, myHobbies);

        hobbiesListView = (ListView) findViewById(R.id.hobbiesListView);
        hobbiesListView.setAdapter(myListAdapter);

        hobbiesListView.setOnItemClickListener(new
            AdapterView.OnItemClickListener(){


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String hobbySelected = "You clicked "+ String.valueOf(parent.getItemAtPosition(position));
                    Toast.makeText(HobbiesActivity.this, hobbySelected, Toast.LENGTH_LONG).show();
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu: this adds items to the ActionBar if available
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
}
