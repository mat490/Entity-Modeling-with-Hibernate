package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.model.LugaresNacimiento;

public class LugaresNacimientoDAOImpl extends GenericDAOImpl<LugaresNacimiento, Integer> {
    private static LugaresNacimientoDAOImpl instance;
    public static LugaresNacimientoDAOImpl getInstance() {
        if (instance == null)
            instance = new LugaresNacimientoDAOImpl();
        return instance;
    }
}
