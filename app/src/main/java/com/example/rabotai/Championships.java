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
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        // this.newsImg = newsImg;
    }
    //asdasd
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Long getDateStart() {
        return dateStart;
    }

    public Long getDateEnd() {
        return dateEnd;
    }

    public void setDateStart(long dateStart){
        this.dateStart=dateStart;
    }
    public void setDateEnd(long dateEnd){
        this.dateEnd=dateEnd;
    }

}
