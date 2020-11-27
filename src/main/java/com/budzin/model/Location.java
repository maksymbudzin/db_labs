package com.budzin.model;


import com.budzin.annotation.Table;

import javax.persistence.*;

@Table(name = "Location")
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Country")
    private String Country;

    @Column(name = "City")
    private String City;

    public Location(int id, String country, String city) {
        this.id = id;
        Country = country;
        City = city;
    }

    public Location(String country, String city) {
        this(-1, country, city);
    }

    public Location() {

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
