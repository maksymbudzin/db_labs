package com.budzin.model;

import com.budzin.annotation.Colomn;
import com.budzin.annotation.Primary_key;
import com.budzin.annotation.Table;

@Table(name = "Location")
public class Location {

    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "Country")
    private String Country;

    @Colomn(name = "City")
    private String City;

    public Location(int id, String country, String city) {
        this.id = id;
        Country = country;
        City = city;
    }

    public Location(String country, String city) {
        this(-1, country, city);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                ",\n Country='" + Country + '\'' +
                ",\n City='" + City + '\'' +
                '}';
    }
}
