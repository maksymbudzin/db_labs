package com.budzin.controller;

import com.budzin.DAO.implementation.CustomerDAO;
import com.budzin.DAO.implementation.RatingDAO;
import com.budzin.model.Customer;
import com.budzin.model.Rating;

import java.sql.SQLException;
import java.util.List;

public class RatingController implements GeneralController<Rating> {

    private static final RatingDAO ratings = new RatingDAO();

    public RatingController() {
    }

    @Override
    public List<Rating> getAll() throws SQLException {
        return ratings.getAll();
    }

    @Override
    public Rating getById(int id) throws SQLException {
        return ratings.getById(id);
    }

    @Override
    public void create(Rating object) throws SQLException {
        ratings.create(object);

    }

    @Override
    public void update(int id, Rating object) {
        ratings.update(id, object);
    }

    @Override
    public void delete(int id) {
        ratings.delete(id);
    }

}
