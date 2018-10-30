package com.example.rabotai;

import android.util.Log;

/**
 * Created by Администратор on 30.10.2018.
 */

public class Championships {
    private Long id;
    private Long dateStart;
    private Long dateEnd;
    private String name;


    public Championships(){

    }
    public Championships (Long newsId,String name,Long dateStart,Long dateEnd){
    //public Championships (String newsId,Long dateStart,Long dateEnd,String name){
        this.id = newsId;
        this.name = name;
        Log.e("wer", "qwe"+name);
        this.dateStart = dateStart;
        Log.e("wer","qwe"+dateStart);
        this.dateEnd = dateEnd;
        // this.newsImg = newsImg;
    }
    //asdasd
    public Long getId() {
        Log.w ("Error", "Error 5");
        return id;
    }
    public String getName() {
        Log.w ("Error", "Error 57"+name);
        return name;
    }

    public Long getDateStart() {
        return dateStart;
    }

    public Long getDateEnd() {
        return dateEnd;
    }

}
