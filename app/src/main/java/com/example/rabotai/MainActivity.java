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
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    NavigationView navigationView;
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    ListView listView;
    List<News> newsList;
   // BaseAdapter adapter;

    //


    //


   // Context context;
   // LayoutInflater layoutInflater;
   // ArrayList<CustomAdapter.NewsGetter> news = new ArrayList<CustomAdapter.NewsGetter>();
   // String[] zagolovok = {"Novost 1","Novost 2","Novost 3","Novost 4","Novost 5","Novost 6","Novost 7","Novost 8"};
   // String[] novost = {"lalal 1","lalal 2","lalal 3","lalal 4","lalal 5","lalal 6","lalal 7","lalal 8",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        newsList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("news");
       // databaseNews = FirebaseDatabase.getInstance().getReference("news");

        //Функция заполнения + проверка на интернет
       /* if(internetConnection() == true)
        {
           // fillData();

        }
        else {
            Toast.makeText(this, "ELISABET OLSEN SAY: PIZDEC NAHOOY BLET", Toast.LENGTH_LONG).show();
        }*/

        //Обьевляем адаптеру
       // adapter = new CustomAdapter(this,news);

       // listView.setAdapter(adapter);
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String news = String.valueOf(parent.getItemIdAtPosition(position));
                Toast.makeText(MainActivity.this,news,Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter = new CustomAdapter(this,news);
        listView.setAdapter(adapter);
        */
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

                }
                    return false;
                }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();


            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    newsList.clear();
                    for (DataSnapshot newsSnapshot : dataSnapshot.getChildren()) {
                        Log.e("asasasdasd", "asdserre" + dataSnapshot.getChildren().toString());

                        News news = newsSnapshot.getValue(News.class);
                        Log.e("asasasdasd", "asdserre");
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
    //Функция заполнения listView
    /*
    * 1)загрузить данные из базы
    * 2)нам нужно их распихать
    * 3)должно работать изи просто*/
  /*  void fillData(){

        for (int i = 0 ;i<zagolovok.length;i++){
            news.add(new CustomAdapter.NewsGetter(zagolovok[i],novost[i],R.drawable.kit));
        }
    }*/

    //Функция  проверка на интернет
    public boolean internetConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }
        return false;
    }

}
