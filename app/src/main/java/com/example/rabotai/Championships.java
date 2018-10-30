package com.example.rabotai;

import android.util.Log;

/**
 * Created by Администратор on 30.10.2018.
 */

public class Championships {
    private String id;
    private Long dateStart;
    private Long dateEnd;
    private String name;


    public Championships(){

    }
    public Championships (String newsId,String name){
    //public Championships (String newsId,Long dateStart,Long dateEnd,String name){
        this.id = newsId;
        this.name = name;
        //this.dateStart = dateStart;
        //this.dateEnd = dateEnd;
        // this.newsImg = newsImg;
    }
    //asdasd
    public String getId() {
        Log.w ("Error", "Error 5");
        return id;
    }
    public String getName() {
        Log.w ("Error", "Error 5");
        return name;
    }
    /*
    public Long getDateStart() {
        Log.w ("Error", "Error 5");
        return dateStart;
    }

    public Long getDateEnd() {
        return dateEnd;
    }
    */
}
