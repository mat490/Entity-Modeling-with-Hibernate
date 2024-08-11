package edu.unam.proyecto.avance.dao.impl;


import edu.unam.proyecto.avance.model.GruposSanguineos;

public class GruposSanguineosDAOImpl extends GenericDAOImpl<GruposSanguineos, Integer> {
    private static GruposSanguineosDAOImpl instance;
    public static GruposSanguineosDAOImpl getInstance() {
        if (instance == null)
            instance = new GruposSanguineosDAOImpl();
        return instance;
    }
}
