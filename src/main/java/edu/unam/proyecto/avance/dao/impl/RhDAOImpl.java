package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.Rh;

public class RhDAOImpl extends GenericDAOImpl<Rh, Integer>{
    private static RhDAOImpl instance;
    public static RhDAOImpl getInstance() {
        if (instance == null)
            instance = new RhDAOImpl();
        return instance;
    }
}
