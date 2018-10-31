package com.example.rabotai;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    NavigationView navigationView;
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    ListView listView;
    List<News> newsList;
    String name;
    String description;
    Long dateLong;
    Date date = new Date();
    String dateNews;
    //


    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        newsList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("news");

        navigationView=findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.auth:
                        Intent toAuth = new Intent(MainActivity.this, Auth.class);
                        startActivity(toAuth);
                        break;
                    case R.id.main:
                        break;
                    case R.id.map:
                        Intent toMap = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(toMap);
                        break;
                    case R.id.chemp:
                        Intent toChemp = new Intent(MainActivity.this,ChampionshipActivity.class);
                        startActivity(toChemp);
                        break;
                    case R.id.par:
                        Intent toPar = new Intent(MainActivity.this,ParticipantsActivity.class);
                        startActivity(toPar);
                        break;

                }
                    return false;
                }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(internetConnection() == true) {
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    newsList.clear();
                    for (DataSnapshot newsSnapshot : dataSnapshot.getChildren()) {

                        News news = newsSnapshot.getValue(News.class);
                        newsList.add(news);
                    }
                    ArrayAdapter adapter = new NewsList(MainActivity.this, newsList);
                    listView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else {
            toastMessage("Отсутствует интернет-соединение");
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        name = newsList.get(position).getName();
                       description = newsList.get(position).getDescription();
                       Intent FullNews0 = new Intent(MainActivity.this,FullNews.class);
                        dateLong = newsList.get(position).getDate()*1000;
                        date = new java.util.Date(dateLong);
                        String dateTimeNews = new SimpleDateFormat("MM dd, yyyy, hh:mma").format(date);
                        dateNews = dateTimeNews;
                        FullNews0.putExtra("fullname",name);
                        FullNews0.putExtra("fulldesc",description);
                        FullNews0.putExtra("fulldate",dateNews);
                       startActivity(FullNews0);
                       break;
                    case 1:
                    name = newsList.get(position).getName();
                    description = newsList.get(position).getDescription();
                    Intent FullNews1 = new Intent(MainActivity.this,FullNews.class);
                    dateLong = newsList.get(position).getDate()*1000;
                    date = new java.util.Date(dateLong);
                    String dateTimeNews1 = new SimpleDateFormat("MM dd, yyyy, hh:mma").format(date);
                    dateNews = dateTimeNews1;
                    FullNews1.putExtra("fullname",name);
                    FullNews1.putExtra("fulldesc",description);
                    FullNews1.putExtra("fulldate",dateNews);
                    startActivity(FullNews1);
                    break;
                    case 2:
                        name = newsList.get(position).getName();
                        description = newsList.get(position).getDescription();
                        Intent FullNews2 = new Intent(MainActivity.this,FullNews.class);
                        dateLong = newsList.get(position).getDate()*1000;
                        date = new java.util.Date(dateLong);
                        String dateTimeNews2 = new SimpleDateFormat("MM dd, yyyy, hh:mma").format(date);
                        dateNews = dateTimeNews2;
                        FullNews2.putExtra("fullname",name);
                        FullNews2.putExtra("fulldesc",description);
                        FullNews2.putExtra("fulldate",dateNews);
                        startActivity(FullNews2);
                               break;
                    case 3:
                        name = newsList.get(position).getName();
                        description = newsList.get(position).getDescription();
                        Intent FullNews3 = new Intent(MainActivity.this,FullNews.class);
                        dateLong = newsList.get(position).getDate()*1000;
                        date = new java.util.Date(dateLong);
                        String dateTimeNews3 = new SimpleDateFormat("MM dd, yyyy, hh:mma").format(date);
                        dateNews = dateTimeNews3;
                        FullNews3.putExtra("fullname",name);
                        FullNews3.putExtra("fulldesc",description);
                        FullNews3.putExtra("fulldate",dateNews);
                        startActivity(FullNews3);
                        break;
                }
            }
        });
    }

    //Функция  проверка на интернет
    public boolean internetConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }
        return false;
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}
