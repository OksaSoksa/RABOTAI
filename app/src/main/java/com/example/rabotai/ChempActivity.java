package com.example.rabotai;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ChempActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    List<Chemps> chempsList;
    ListView chempListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemp);
        chempListView = findViewById(R.id.chempListView);
        chempsList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        Log.w ("Error", "Error 1");
        databaseReference = database.getReference("championships");
        Log.w ("Error", "Error 2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.w ("Error", "Error 3");
                chempsList.clear();
                for(DataSnapshot chempSnapshot:dataSnapshot.getChildren()){
                    Log.w ("Error", "Error");
                    Chemps chemps = chempSnapshot.getValue(Chemps.class);
                    //Log.w ("Error", "ChEMPS VALUSE "+ chemps.getName());
                    chempsList.add(chemps);
                }
                ArrayAdapter adapter = new ChempsList(ChempActivity.this,chempsList);
                Log.w ("Error", "Error 5");
                chempListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
