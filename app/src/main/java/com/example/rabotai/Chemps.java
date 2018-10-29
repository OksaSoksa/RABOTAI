package com.example.rabotai;

import android.util.Log;

/**
 * Created by Администратор on 25.10.2018.
 */

public class Chemps {
    private String id;
    private Long dateStart;
    private Long dateEnd;
    private String name;


    public Chemps(){

    }
    public Chemps (String newsId,Long dateStart,Long dateEnd,String name){
        this.id = newsId;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        // this.newsImg = newsImg;
    }
    //asdasd
    public String getId() {

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
}

