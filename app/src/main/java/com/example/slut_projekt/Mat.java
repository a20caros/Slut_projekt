package com.example.slut_projekt;

public class Mat {

    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;
    private Auxdata auxdata;

    public String getName() {

        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }


    @Override
    public String toString() {

        return name;
    }
}
