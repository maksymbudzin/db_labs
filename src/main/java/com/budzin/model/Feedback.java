package com.budzin.model;

import com.budzin.annotation.Colomn;
import com.budzin.annotation.Primary_key;
import com.budzin.annotation.Table;

@Table(name = "Feedback")
public class Feedback {

    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "feedback_text")
    private String feedback_text;

    @Colomn(name = "time")
    private String time;

    @Colomn(name = "Customer_id")
    private String Customer_id;

    @Colomn(name = "Customer_Trip_Order_id")
    private String Customer_Trip_Order_id;

    public Feedback(int id, String name, String time, String customer_id, String customer_Trip_Order_id) {
        this.id = id;
        this.feedback_text = name;
        this.time = time;
        Customer_id = customer_id;
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    public Feedback(String name, String time, String customer_id, String customer_Trip_Order_id) {
        this(-1, name, time, customer_id, customer_Trip_Order_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback_text() {
        return feedback_text;
    }

    public void setFeedback_text(String feedback_text) {
        this.feedback_text = feedback_text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public String getCustomer_Trip_Order_id() {
        return Customer_Trip_Order_id;
    }

    public void setCustomer_Trip_Order_id(String customer_Trip_Order_id) {
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                ",\n name='" + feedback_text + '\'' +
                ",\n time='" + time + '\'' +
                ",\n Customer_id='" + Customer_id + '\'' +
                ",\n Customer_Trip_Order_id='" + Customer_Trip_Order_id + '\'' +
                '}';
    }
}
