package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.EstadosCiviles;

public class EstadosCivilesDAOImpl extends  GenericDAOImpl<EstadosCiviles, Integer> {
    private static EstadosCivilesDAOImpl instance;
    public static EstadosCivilesDAOImpl getInstance() {
        if (instance == null)
            instance = new EstadosCivilesDAOImpl();
        return instance;
    }
}
