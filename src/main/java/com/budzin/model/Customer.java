package com.budzin.model;


import com.budzin.annotation.Table;

import javax.persistence.*;

@Table(name = "Customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public Customer(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Customer(String name, String surname) {
        this(-1, name, surname);

    }

    public Customer() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                        ",\n name='" + name + '\'' +
                        ",\n surname='" + surname + '\'' +
                        '}';
    }
}
