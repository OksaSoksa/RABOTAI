/*package com.example.rabotai;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class CustomAdapter extends BaseAdapter {

    //оПисание переменных
        ArrayList arrayListCustomAdapter = new ArrayList();
        Context context;
        LayoutInflater layoutInflater;
        ArrayList<NewsGetter> news;

/*
     public CustomAdapter(@NonNull Context context, String [] zagolovok, String[] novosti) {
         super(context,R.layout.custom  ,zagolovok);
     }
*/
    //Представление для листа
   /* CustomAdapter(Context NewsContex, ArrayList<NewsGetter> newsAdapter){
        context = NewsContex;
        news = newsAdapter;
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    //берем кол-во
     @Override
     public int getCount() {
         return news.size();
     }

     //Номер элемента
     @Override
     public Object getItem(int position) {
         return news.get(position);
     }
    //позиция
     @Override
     public long getItemId(int position) {
         return position;
     }

     //Представление для ListView
     @NonNull
     @Override
     public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = layoutInflater.inflate(R.layout.custom,parent,false);
        }

        // Обращение к классу и вызов функции
        NewsGetter newsGetter = getNews(position);

         ((TextView)view.findViewById(R.id.zagolovok)).setText(newsGetter.zagolovok);
         ((TextView)view.findViewById(R.id.novost)).setText(newsGetter.novosti);
         //((ImageView)view.findViewById(R.id.imgNews)).setImageResource(newsGetter.image);

         return view;
     }

     //Отдельный класс для получение данных
    public static class NewsGetter {

        String zagolovok;
        String novosti;
        int image;

        NewsGetter(String _zagolovok, String _novosti, int _image) {
            zagolovok = _zagolovok;
            novosti = _novosti;
            image = _image;
        }
    }

    NewsGetter getNews(int position) {
        return ((NewsGetter) getItem(position));
    }
 }*/

