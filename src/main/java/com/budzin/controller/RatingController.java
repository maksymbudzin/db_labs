package com.budzin.controller;

import com.budzin.DAO.implementation.AbstractGenericDaoImpl;

import com.budzin.DAO.implementation.RatingDAO;

import com.budzin.model.Rating;


public class RatingController
        extends AbstractGenericControllerImpl<Rating> {

    private final RatingDAO ratingDAO = new RatingDAO();

    @Override
    public AbstractGenericDaoImpl<Rating> getDao() {
        return ratingDAO;
    }


}
