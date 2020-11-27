package com.budzin.model;


import com.budzin.annotation.Table;

import javax.persistence.*;

@Table(name = "Trip_Order")
@Entity
public class Trip_Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price_in_dollars")
    private String price_in_dollars;

    @Column(name = "date")
    private String date;

    @Column(name = "Customer_id")
    private String Customer_id;

    public Trip_Order(int id, String price_in_dollars, String date, String customer_id) {
        this.id = id;
        this.price_in_dollars = price_in_dollars;
        this.date = date;
        Customer_id = customer_id;
    }

    public Trip_Order(String price_in_dollars, String date, String customer_id) {
        this(-1, price_in_dollars, date, customer_id);
    }

    public Trip_Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice_in_dollars() {
        return price_in_dollars;
    }

    public void setPrice_in_dollars(String price_in_dollars) {
        this.price_in_dollars = price_in_dollars;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    @Override
    public String toString() {
        return
                "\n id=" + id +
                        ",\n  price_in_dollars='" + price_in_dollars + '\'' +
                        ",\n date='" + date + '\'' +
                        ",\n Customer_id='" + Customer_id + '\'' +
                        '}';
    }
}
