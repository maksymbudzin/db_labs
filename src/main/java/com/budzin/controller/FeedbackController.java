package com.budzin.controller;

import com.budzin.DAO.implementation.AbstractGenericDaoImpl;

import com.budzin.DAO.implementation.FeedbackDAO;

import com.budzin.model.Feedback;

public class FeedbackController
        extends AbstractGenericControllerImpl<Feedback> {

    private final FeedbackDAO feedbackDAO = new FeedbackDAO();

    @Override
    public AbstractGenericDaoImpl<Feedback> getDao() {
        return feedbackDAO;
    }


}
