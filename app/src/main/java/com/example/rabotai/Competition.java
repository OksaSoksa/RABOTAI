package com.example.rabotai;

/**
 * Created by Администратор on 30.10.2018.
 */

public class Competition {
    private String name;
    private String block;
    //img
    private String description;
    private String address;
    //smp
    private String oo;

    public Competition(){

    }

    public Competition(String name, String block, String description, String address, String oo) {
        this.name = name;
        this.block = block;
        this.description = description;
        this.address = address;
        this.oo = oo;
    }

    public String getName() {
        return name;
    }

    public String getBlock() {
        return block;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getOo() {
        return oo;
    }
}
