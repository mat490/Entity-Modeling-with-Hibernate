package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.Direccion;

public class DireccionDAOImpl extends GenericDAOImpl<Direccion, Integer>{
    private static DireccionDAOImpl instance;
    public static DireccionDAOImpl getInstance() {
        if (instance == null)
            instance = new DireccionDAOImpl();
        return instance;
    }
}
