package com.example.rabotai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 30.10.2018.
 */

public class ChampionshipActivity extends AppCompatActivity{
        DatabaseReference databaseReference;
        FirebaseDatabase database;
        List<Championships> chempsList;
        ListView chempListView;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chemp);
            chempListView = findViewById(R.id.chempListView);
            chempsList = new ArrayList<>();
            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference("championships");
        }

        @Override
        protected void onStart() {
            super.onStart();
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    chempsList.clear();
                    for(DataSnapshot championshipSnapshot:dataSnapshot.getChildren()){
                        Championships championships = championshipSnapshot.getValue(Championships.class);

                        championships.setDateStart((Long) championshipSnapshot.child("date-start").getValue());
                        championships.setDateEnd((Long) championshipSnapshot.child("date-end").getValue());

                        chempsList.add(championships);
                    }
                    ArrayAdapter adapter = new ChampionshipsList(ChampionshipActivity.this,chempsList);
                    chempListView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }
}
