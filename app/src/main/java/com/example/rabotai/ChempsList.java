package com.example.rabotai;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 25.10.2018.
 */

public class ChempsList extends ArrayAdapter<Chemps> {
    private Activity context;
    private List<Chemps> chempsList;
    Date date = new Date();
    Long dateLongStart;
    Long dateLongEnd;
    public ChempsList (Activity context,List<Chemps> chempsList){
        super (context,R.layout.custom_chemp, chempsList);
        this.context = context;
        this.chempsList = chempsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.custom_chemp,null,true);
        Log.w ("Error", "CHAMP LIST 1");
        TextView nameText = listViewItem.findViewById(R.id.chempName);
        TextView dateStart = listViewItem.findViewById(R.id.dateStart);
        TextView dateEnd = listViewItem.findViewById(R.id.dateEnd);
        Chemps chemps = chempsList.get(position);
        Log.w ("Error", "CHAMp 2");
        nameText.setText(chemps.getName());
        Log.w ("Error", "champ 3");
      //  dateLongStart = chemps.getDateStart()*1000;
      //  date = new java.util.Date(dateLongStart);
       // String dateTimsStart = new SimpleDateFormat("MM dd,yyyy,hh:mma").format(date);
       // dateStart.setText(dateTimsStart);
        return listViewItem;



    }
}
