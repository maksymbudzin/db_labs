package com.budzin.controller;

import com.budzin.model.TripAdvizor_objec;

import java.sql.SQLException;
import java.util.List;

public interface GeneralController <E> {
    List<E> getAll() throws SQLException;
    E getById(int id) throws SQLException;
    void create(E object) throws SQLException;
    void update(int id, E object);
    void delete(int id);


}
