package com.budzin.controller;

import com.budzin.DAO.implementation.CustomerDAO;
import com.budzin.DAO.implementation.Owner_informationDAO;
import com.budzin.model.Customer;
import com.budzin.model.Owner_information;

import java.sql.SQLException;
import java.util.List;

public class Owner_informationController implements GeneralController<Owner_information> {
    private static final Owner_informationDAO owner_informationDAO = new Owner_informationDAO();

    public Owner_informationController () {
    }

    @Override
    public List<Owner_information> getAll() throws SQLException {
        return owner_informationDAO.getAll();
    }

    @Override
    public Owner_information getById(int id) throws SQLException {
        return owner_informationDAO.getById(id);
    }

    @Override
    public void create(Owner_information object) throws SQLException {
        owner_informationDAO.create(object);

    }

    @Override
    public void update(int id, Owner_information object) {
        owner_informationDAO.update(id, object);
    }

    @Override
    public void delete(int id) {
        owner_informationDAO.delete(id);
    }
}
