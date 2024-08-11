package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.DatosPersonalesGenerales;

public class DatosPersonalesGeneralesDAOImpl extends GenericDAOImpl<DatosPersonalesGenerales, Integer>{
    private static DatosPersonalesGeneralesDAOImpl instance;
    public static DatosPersonalesGeneralesDAOImpl getInstance() {
        if (instance == null)
            instance = new DatosPersonalesGeneralesDAOImpl();
        return instance;
    }

}
