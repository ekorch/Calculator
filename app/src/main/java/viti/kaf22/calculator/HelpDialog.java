package viti.kaf22.calculator;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by korch on 13.11.17.
 */

public class HelpDialog extends DialogFragment {

    private String [] list;
    private ListView listView;
    private String aboutDeveloper = "About developer: Application developed cadet`s \n" +
            "231 student`s group senior soilder Korchevnii Evhenii";
    private String aboutApplication = "About application: application developed in \n" +
            "studied goals in Military Institut Telecommunication and Information \n" +
            "Technologies";

    public  HelpDialog(){}

    @SuppressLint("ValidFragment")
    public HelpDialog(String [] list){
        this.list = list;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Help")
                .setIcon(R.mipmap.about)
                .setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Toast.makeText(getActivity(), aboutDeveloper, Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(getActivity(), aboutApplication, Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                });

        return dialog.create();
    }
}
