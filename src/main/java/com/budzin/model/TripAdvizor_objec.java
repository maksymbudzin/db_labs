package com.budzin.model;

import com.budzin.annotation.Colomn;
import com.budzin.annotation.Primary_key;
import com.budzin.annotation.Table;

@Table(name = "TripAdvizor_objec")
public class TripAdvizor_objec {

    @Primary_key
    @Colomn(name = "id")
    private int id;

    @Colomn(name = "objec_name")
    private String objec_name;

    @Colomn(name = "number_of_star")
    private String number_of_star;

    @Colomn(name = "free_room")
    private String free_room;

    @Colomn(name = "busy_room")
    private String busy_room;

    @Colomn(name = "all_inclusive")
    private String all_inclusive;

    @Colomn(name = "ultra_all_inclusive")
    private String ultra_all_inclusive;

    public TripAdvizor_objec(int id, String objec_name, String number_of_star, String free_room, String busy_room,
                             String all_inclusive, String ultra_all_inclusive) {
        this.id = id;
        this.objec_name = objec_name;
        this.number_of_star = number_of_star;
        this.free_room = free_room;
        this.busy_room = busy_room;
        this.all_inclusive = all_inclusive;
        this.ultra_all_inclusive = ultra_all_inclusive;
    }

    public TripAdvizor_objec( String objec_name, String number_of_star, String free_room, String busy_room,
                             String all_inclusive, String ultra_all_inclusive) {
        this(-1, objec_name, number_of_star, free_room, busy_room, all_inclusive, ultra_all_inclusive);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjec_name() {
        return objec_name;
    }

    public void setObjec_name(String objec_name) {
        this.objec_name = objec_name;
    }

    public String getNumber_of_star() {
        return number_of_star;
    }

    public void setNumber_of_star(String number_of_star) {
        this.number_of_star = number_of_star;
    }

    public String getFree_room() {
        return free_room;
    }

    public void setFree_room(String free_room) {
        this.free_room = free_room;
    }

    public String getBusy_room() {
        return busy_room;
    }

    public void setBusy_room(String busy_room) {
        this.busy_room = busy_room;
    }

    public String getAll_inclusive() {
        return all_inclusive;
    }

    public void setAll_inclusive(String all_inclusive) {
        this.all_inclusive = all_inclusive;
    }

    public String getUltra_all_inclusive() {
        return ultra_all_inclusive;
    }

    public void setUltra_all_inclusive(String ultra_all_inclusive) {
        this.ultra_all_inclusive = ultra_all_inclusive;
    }

    @Override
    public String toString() {
        return
                "\n id=" + id +
                ",\n objec_name='" + objec_name + '\'' +
                ",\n number_of_star='" + number_of_star + '\'' +
                ",\n free_room='" + free_room + '\'' +
                ",\n busy_room='" + busy_room + '\'' +
                ",\n all_inclusive='" + all_inclusive + '\'' +
                ",\n ultra_all_inclusive='" + ultra_all_inclusive + '\'' +
                '}';
    }
}
