package com.example.rabotai;

/**
 * Created by Администратор on 23.10.2018.
 */

public class News {
   private String id;
   private String description;
   private String name;
   private String image;

    public News(){

    }
    public News (String newsId,String name,String description,String image){
        this.id = newsId;
        this.name = name;
        this.description = description;
       // this.newsImg = newsImg;
    }
    //asdasd
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public String getImg() {
        return image;
    }
}

