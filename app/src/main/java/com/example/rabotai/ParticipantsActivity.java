package com.example.rabotai;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ParticipantsActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    ListView parList;
    EditText SearchPar;
    List<Participants> participantsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.par_layout);
        parList = findViewById(R.id.listPar);
        participantsList = new ArrayList<>();
        SearchPar = findViewById(R.id.SearchText);
        database = FirebaseDatabase.getInstance();

        databaseReference = database.getReference("participants");

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                participantsList.clear();
                for(DataSnapshot parSnapshot: dataSnapshot.getChildren()){
                    Participants participants = parSnapshot.getValue(Participants.class);
                    participantsList.add(participants);
                }
                ArrayAdapter adapter = new ParticipantsList(ParticipantsActivity.this,participantsList);
                parList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
