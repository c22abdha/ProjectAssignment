package com.example.projectassignment;

import com.google.gson.annotations.SerializedName;

public class Country {

    String ID;
    String name;
    int Size;
    String location;
    @SerializedName("cost")
    int population;
    String company;
    String auxdata;


    public Country(String ID, String name,int Size, String location, int population,
                   String company, String auxdata)
    {
        this.ID = ID;
        this.name = name;
        this.Size = Size;
        this.location = location;
        this.population = population;
        this.company = company;
        this.auxdata = auxdata;

    }

    public String ID() {

        return ID;
    }


    public String getName() {

        return name;
    }

    public int getSize() {

        return Size;
    }

    public String getLocation() {

        return location;
    }
    public int getPopulation() {

        return population;
    }



    public String getCompany() {

        return company;
    }

    public String getAuxdata() {

        return auxdata;
    }




}