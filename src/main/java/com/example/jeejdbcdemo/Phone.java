package com.example.jeejdbcdemo;

public class Phone {

    private int id;
    private String model;
    private String make;
    private double price;
    private double diagonal;
    private int storage;
    private String OStype;

    public Phone(int id, String model, String make, double price, double diagonal, int storage, String OStype) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.price = price;
        this.diagonal = diagonal;
        this.storage = storage;
        this.OStype = OStype;
    }

    public Phone(String model, String make, double price, double diagonal, int storage, String OStype) {
        this.model = model;
        this.make = make;
        this.price = price;
        this.diagonal = diagonal;
        this.storage = storage;
        this.OStype = OStype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOStype() {
        return OStype;
    }

    public void setOStype(String OStype) {
        this.OStype = OStype;
    }
}
