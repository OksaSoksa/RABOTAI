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
 * Created by Администратор on 30.10.2018.
 */

public class ChampionshipsList extends ArrayAdapter<Championships> {
    private Activity context;
    private List<Championships> championshipsList;
    Date date = new Date();
    Long dateLongStart;
    Long dateLongEnd;
    public ChampionshipsList (Activity context,List<Championships> championshipsList){
        super (context,R.layout.custom_chemp, championshipsList);
        Log.e("werwer","werwedsfse1");
        this.context = context;
        Log.e("werwer","qwsdeqw2"+context);
        this.championshipsList = championshipsList;
        Log.e("werwer","qwes3"+championshipsList);
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
        Championships championships = championshipsList.get(position);
        Log.w ("Error", "CHAMp 2");
        nameText.setText(championships.getName());
        Log.w ("Error", "champ 3");
         // dateLongStart = championships.getDateStart()*1000;
          //date = new java.util.Date(dateLongStart);
         //String dateTimesStart = new SimpleDateFormat("MM dd,yyyy,hh:mma").format(date);
        // Log.e("Error","qwe"+dateTimesStart);
        // dateStart.setText(dateTimesStart);
        return listViewItem;



    }
}
