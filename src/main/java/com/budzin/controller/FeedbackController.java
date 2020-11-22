package com.budzin.controller;

import com.budzin.DAO.implementation.CustomerDAO;
import com.budzin.DAO.implementation.FeedbackDAO;
import com.budzin.model.Customer;
import com.budzin.model.Feedback;

import java.sql.SQLException;
import java.util.List;

public class FeedbackController implements GeneralController<Feedback> {

    private static final FeedbackDAO feedbacks = new FeedbackDAO();
    public FeedbackController() {
    }

    @Override
    public List<Feedback> getAll() throws SQLException {
        return feedbacks.getAll();
    }

    @Override
    public Feedback getById(int id) throws SQLException {
        return feedbacks.getById(id);
    }

    @Override
    public void create(Feedback object) throws SQLException {
        feedbacks.create(object);

    }

    @Override
    public void update(int id, Feedback object) {
        feedbacks.update(id, object);
    }

    @Override
    public void delete(int id) {
        feedbacks.delete(id);
    }
}
