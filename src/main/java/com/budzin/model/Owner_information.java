package com.budzin.model;


import com.budzin.annotation.Table;

import javax.persistence.*;

@Table(name = "Owner_information")
@Entity
public class Owner_information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Surname")
    private String Surname;

    @Column(name = "country")
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

    public Owner_information() {

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
