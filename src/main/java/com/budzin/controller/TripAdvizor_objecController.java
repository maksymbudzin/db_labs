package com.budzin.controller;


import com.budzin.DAO.implementation.TripAdvizor_objecDAO;
import com.budzin.model.TripAdvizor_objec;

import java.sql.SQLException;
import java.util.List;

public class TripAdvizor_objecController implements GeneralController<TripAdvizor_objec> {

    private static final TripAdvizor_objecDAO tripAdvizor_objects = new TripAdvizor_objecDAO();

    public TripAdvizor_objecController() {
    }

    @Override
    public List<TripAdvizor_objec> getAll() throws SQLException {
        return tripAdvizor_objects.getAll();
    }

    @Override
    public TripAdvizor_objec getById(int id) throws SQLException {
        return tripAdvizor_objects.getById(id);
    }

    @Override
    public void create(TripAdvizor_objec object) throws SQLException {
        tripAdvizor_objects.create(object);

    }

    @Override
    public void update(int id, TripAdvizor_objec object) {
        tripAdvizor_objects.update(id, object);
    }

    @Override
    public void delete(int id) {
        tripAdvizor_objects.delete(id);
    }
}
