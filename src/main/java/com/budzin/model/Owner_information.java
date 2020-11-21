package com.budzin.model;

import com.budzin.annotation.Colomn;
import com.budzin.annotation.Primary_key;
import com.budzin.annotation.Table;

@Table(name = "Owner_information")
public class Owner_information {


    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "Name")
    private String Name;

    @Colomn(name = "Surname")
    private String Surname;

    @Colomn(name = "country")
    private String country;

    public Owner_information(int id, String name, String surname, String country) {
        this.id = id;
        Name = name;
        Surname = surname;
        this.country = country;
    }

    public Owner_information(String name, String surname, String country) {
        this(-1, name, surname, country);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                ",\n Name='" + Name + '\'' +
                ",\n Surname='" + Surname + '\'' +
                ",\n country='" + country + '\'' +
                '}';
    }
}
