package com.example.rabotai;

/**
 * Created by Администратор on 25.10.2018.
 */

public class Participants {
    private String firstname;
    private String lastname;
    private String role;

    private String image;

    public Participants(){

    }
    public Participants (String firstname,String lastname,String role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        // this.newsImg = newsImg;
    }
    //asdasd

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRole() {
        return role;
    }

    public String getImage() {
        return image;
    }
}
