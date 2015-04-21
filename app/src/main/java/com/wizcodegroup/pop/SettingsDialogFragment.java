package com.wizcodegroup.pop;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Lheye on 4/20/15.
 */

//Dialog Fragment Requires Minimum API11
public class SettingsDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Build the Dialog Box
        AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());
        myDialog.setTitle("Settings Dialog");
        myDialog.setMessage("This is the Settings Dialog");
        myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "OK button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel Button Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        //Return the Created Dialog
        return myDialog.create();
    }
}
