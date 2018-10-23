package com.example.rabotai;

/**
 * Created by Администратор on 23.10.2018.
 */

public class News {
    String newsId;
    String newsDescription;
    String newsName;
   // Integer newsImg;

    public News(){

    }
    public News (String newsId,String newsName,String newsDescription){
        this.newsId = newsId;
        this.newsName = newsName;
        this.newsDescription = newsDescription;
       // this.newsImg = newsImg;
    }
    //asdasd
    public String getNewsId() {
        return newsId;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public String getNewsName() {
        return newsName;
    }
/*
    public Integer getNewsImg() {
        return newsImg;
    }*/
}

