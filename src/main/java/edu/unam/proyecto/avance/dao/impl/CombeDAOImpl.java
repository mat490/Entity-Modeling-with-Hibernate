package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.Combe;

public class CombeDAOImpl extends GenericDAOImpl<Combe, Integer>{
    private static CombeDAOImpl instance;
    public static CombeDAOImpl getInstance() {
        if (instance == null)
            instance = new CombeDAOImpl();
        return instance;
    }
}
