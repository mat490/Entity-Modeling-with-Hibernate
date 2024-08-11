package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.Ocupaciones;

public class OcupacionesDAOImpl extends GenericDAOImpl<Ocupaciones, Integer> {
    private static OcupacionesDAOImpl instance;
    public static OcupacionesDAOImpl getInstance() {
        if (instance == null)
            instance = new OcupacionesDAOImpl();
        return instance;
    }
}
