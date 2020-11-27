package com.budzin.controller;

import com.budzin.DAO.implementation.AbstractGenericDaoImpl;
import com.budzin.DAO.implementation.CustomerDAO;
import com.budzin.model.Customer;


public class CustomerController
        extends AbstractGenericControllerImpl<Customer> {

    private final CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public AbstractGenericDaoImpl<Customer> getDao() {
        return customerDAO;
    }


}