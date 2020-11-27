package com.budzin.controller;

import com.budzin.DAO.implementation.AbstractGenericDaoImpl;


import java.util.List;

public interface AbstractGenericController<E> {
    AbstractGenericDaoImpl<E> getDao();

    List<E> getAll();

    E getById(Integer id);

    void create(E entity);

    void update(Integer id, E entity);

    void delete(Integer id);

}
