package com.example.rabotai;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FullNews extends AppCompatActivity {
    NavigationView navigationView;
    private TextView dateText;
    private TextView nameText;
    private TextView descText;

    Intent fullNameIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);

        dateText = findViewById(R.id.date);
        nameText = findViewById(R.id.name);
        descText = findViewById(R.id.desc);

        Intent fullNameIntent = getIntent();

        String getName = fullNameIntent.getStringExtra("fullname");
        nameText.setText(getName);

       Intent fulldescIntent = getIntent();

        String getDesc = fulldescIntent.getStringExtra("fulldesc");
        descText.setText(getDesc);

        Intent fulldateIntent = getIntent();

        String getDate = fulldateIntent.getStringExtra("fulldate");
        dateText.setText(getDate);
    }
}
