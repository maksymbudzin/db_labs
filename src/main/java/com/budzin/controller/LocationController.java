package com.budzin.controller;

import com.budzin.DAO.implementation.CustomerDAO;
import com.budzin.DAO.implementation.LocationDAO;
import com.budzin.model.Customer;
import com.budzin.model.Location;

import java.sql.SQLException;
import java.util.List;

public class LocationController implements GeneralController<Location> {

    private static final LocationDAO locations = new LocationDAO();

    public LocationController() {
    }

    @Override
    public List<Location> getAll() throws SQLException {
        return locations.getAll();
    }

    @Override
    public Location getById(int id) throws SQLException {
        return locations.getById(id);
    }

    @Override
    public void create(Location object) throws SQLException {
        locations.create(object);

    }

    @Override
    public void update(int id, Location object) {
        locations.update(id, object);
    }

    @Override
    public void delete(int id) {
        locations.delete(id);
    }

}
