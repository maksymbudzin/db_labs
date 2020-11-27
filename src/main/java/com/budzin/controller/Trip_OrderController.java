package com.budzin.controller;

import com.budzin.DAO.implementation.AbstractGenericDaoImpl;

import com.budzin.DAO.implementation.Trip_OrderDAO;

import com.budzin.model.Trip_Order;


public class Trip_OrderController
        extends AbstractGenericControllerImpl<Trip_Order> {

    private final Trip_OrderDAO trip_orderDAO = new Trip_OrderDAO();

    @Override
    public AbstractGenericDaoImpl<Trip_Order> getDao() {
        return trip_orderDAO;
    }


}
