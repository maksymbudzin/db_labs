package com.budzin.controller;

import com.budzin.DAO.implementation.CustomerDAO;
import com.budzin.model.Customer;


import java.sql.SQLException;
import java.util.List;

public class CustomerController implements GeneralController<Customer> {

    private static final CustomerDAO customers = new CustomerDAO();

    public CustomerController() {
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return customers.getAll();
    }

    @Override
    public Customer getById(int id) throws SQLException {
        return customers.getById(id);
    }

    @Override
    public void create(Customer object) throws SQLException {
        customers.create(object);

    }

    @Override
    public void update(int id, Customer object) {
        customers.update(id, object);
    }

    @Override
    public void delete(int id) {
        customers.delete(id);
    }
}
