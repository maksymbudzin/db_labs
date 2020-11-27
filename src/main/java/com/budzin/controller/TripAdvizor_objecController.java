package com.budzin.controller;


import com.budzin.DAO.implementation.AbstractGenericDaoImpl;

import com.budzin.DAO.implementation.TripAdvizor_objecDAO;

import com.budzin.model.TripAdvizor_object;


public class TripAdvizor_objecController
        extends AbstractGenericControllerImpl<TripAdvizor_object> {

    private final TripAdvizor_objecDAO tripAdvizor_objecDAO = new TripAdvizor_objecDAO();

    @Override
    public AbstractGenericDaoImpl<TripAdvizor_object> getDao() {
        return tripAdvizor_objecDAO;
    }


}