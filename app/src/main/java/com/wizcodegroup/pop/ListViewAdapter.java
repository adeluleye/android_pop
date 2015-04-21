package com.wizcodegroup.pop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

/**
 * Created by Lheye on 4/20/15.
 */
public class ListViewAdapter extends ArrayAdapter<String> {
    public ListViewAdapter(Context context, String[] values) {
        super(context, R.layout.list_row_layout, values);
    }

    //Override the getView method for the ArrayAdapter

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());

        View myView = myInflater.inflate(R.layout.list_row_layout, parent, false);

        String myHobby = getItem(position);

        TextView myTextView = (TextView) myView.findViewById(R.id.myTextView);

        //Put Hobby into the TextView
        myTextView.setText(myHobby);

        //Put ImageView into the Layout
        ImageView myImageView = (ImageView) myView.findViewById(R.id.myImageView);
        myImageView.setImageResource(R.drawable.ic_avatar);

        return myView;
    }
}
