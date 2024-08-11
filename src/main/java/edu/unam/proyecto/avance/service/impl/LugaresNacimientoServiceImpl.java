package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.CombeDAOImpl;
import edu.unam.proyecto.avance.dao.impl.LugaresNacimientoDAOImpl;
import edu.unam.proyecto.avance.model.LugaresNacimiento;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class LugaresNacimientoServiceImpl implements GenericDAOService<LugaresNacimiento, Integer> {
    private static LugaresNacimientoServiceImpl instance;
    private static final GenericDAO lugarNacimientoDAO = LugaresNacimientoDAOImpl.getInstance();

    private LugaresNacimientoServiceImpl() {}

    public static LugaresNacimientoServiceImpl getInstance() {
        if (instance == null) {
            instance = new LugaresNacimientoServiceImpl();
        }
        return instance;
    }

    @Override
    public LugaresNacimiento getByID(Integer id) {
        return (LugaresNacimiento) lugarNacimientoDAO.getByID(id);
    }

    @Override
    public List<LugaresNacimiento> getAll() {
        return lugarNacimientoDAO.getAll();
    }

    @Override
    public Boolean insertEntity(LugaresNacimiento entity) {
        return lugarNacimientoDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(LugaresNacimiento entity) {
        return lugarNacimientoDAO.save(entity);
    }

    @Override
    public Boolean delete(LugaresNacimiento entity) {
        return lugarNacimientoDAO.delete(entity);
    }
}
