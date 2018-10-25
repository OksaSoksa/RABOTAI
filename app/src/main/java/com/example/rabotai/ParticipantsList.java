package com.example.rabotai;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 25.10.2018.
 */

public class ParticipantsList extends ArrayAdapter<Participants> {
   private Activity context;
   private List<Participants> participantsList;

    public ParticipantsList (Activity context,List<Participants> participantsList){
        super(context,R.layout.custom_par,participantsList);
        this.context = context;
        this.participantsList = participantsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.custom_par,null,true);
       TextView surname = listViewItem.findViewById(R.id.firstName);
       TextView name = listViewItem.findViewById(R.id.lastName);
       TextView role = listViewItem.findViewById(R.id.role);
        Participants participants = participantsList.get(position);

       surname.setText(participants.getFirstname());
       name.setText(participants.getLastname());
       role.setText(participants.getRole());
        // imgNews.setImage
        return listViewItem;
    }
}
