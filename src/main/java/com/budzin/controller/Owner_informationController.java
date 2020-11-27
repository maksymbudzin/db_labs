package com.budzin.controller;

import com.budzin.DAO.implementation.AbstractGenericDaoImpl;

import com.budzin.DAO.implementation.Owner_informationDAO;

import com.budzin.model.Owner_information;


public class Owner_informationController
        extends AbstractGenericControllerImpl<Owner_information> {

    private final Owner_informationDAO owner_informationDAO = new Owner_informationDAO();

    @Override
    public AbstractGenericDaoImpl<Owner_information> getDao() {
        return owner_informationDAO;
    }


}

