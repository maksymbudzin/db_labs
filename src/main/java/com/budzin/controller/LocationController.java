package com.budzin.controller;

import com.budzin.DAO.implementation.AbstractGenericDaoImpl;

import com.budzin.DAO.implementation.LocationDAO;

import com.budzin.model.Location;


public class LocationController
        extends AbstractGenericControllerImpl<Location> {

    private final LocationDAO locationDAO = new LocationDAO();

    @Override
    public AbstractGenericDaoImpl<Location> getDao() {
        return locationDAO;
    }


}