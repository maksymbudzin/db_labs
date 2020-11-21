package com.budzin.controller;

import com.budzin.DAO.implementation.LocationDAO;
import com.budzin.DAO.implementation.Trip_OrderDAO;
import com.budzin.model.Location;
import com.budzin.model.Rating;
import com.budzin.model.Trip_Order;

import java.sql.SQLException;
import java.util.List;

public class Trip_OrderController implements GeneralController<Trip_Order> {

    private static final Trip_OrderDAO trip_orders = new Trip_OrderDAO();

    public Trip_OrderController() {
    }

    @Override
    public List<Trip_Order> getAll() throws SQLException {
        return trip_orders.getAll();
    }

    @Override
    public Trip_Order getById(int id) throws SQLException {
        return trip_orders.getById(id);
    }

    @Override
    public void create(Trip_Order object) throws SQLException {
        trip_orders.create(object);

    }

    @Override
    public void update(int id, Trip_Order object) {
        trip_orders.update(id, object);
    }

    @Override
    public void delete(int id) {
        trip_orders.delete(id);
    }

}
