package com.example.jeejdbcdemo;

public class Place {

    private int id;
    private String name;
    private String address;
    private String descrip;

    public Place(int id, String name, String address, String descrip) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.descrip = descrip;
    }

    public Place(String name, String address, String descrip) {
        this.name = name;
        this.address = address;
        this.descrip = descrip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
