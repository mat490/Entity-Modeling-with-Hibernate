package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.Sexo;

public class SexoDAOImpl extends GenericDAOImpl<Sexo, Integer> {

    private static SexoDAOImpl instance;
    public static SexoDAOImpl getInstance() {
        if (instance == null)
            instance = new SexoDAOImpl();
        return instance;
    }
}
