package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.Pacientes;

public class PacientesDAOImpl extends GenericDAOImpl<Pacientes, Integer>{
    private static PacientesDAOImpl instance;
    public static PacientesDAOImpl getInstance() {
        if (instance == null)
            instance = new PacientesDAOImpl();
        return instance;
    }


}
