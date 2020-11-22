package com.budzin.model;

import com.budzin.annotation.Colomn;
import com.budzin.annotation.Primary_key;
import com.budzin.annotation.Table;

@Table(name = "Customer")
public class Customer {
    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "name")
    private String name;

    @Colomn(name = "surname")
    private String surname;

    public Customer(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Customer(String name, String surname) {
        this(-1, name, surname);

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
