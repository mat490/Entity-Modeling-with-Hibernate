package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.EstadosCivilesDAOImpl;
import edu.unam.proyecto.avance.dao.impl.OcupacionesDAOImpl;
import edu.unam.proyecto.avance.model.Ocupaciones;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class OcupacionesServiceImpl implements GenericDAOService<Ocupaciones, Integer> {
    private static OcupacionesServiceImpl instance;
    private static final GenericDAO ocupacionDAO = OcupacionesDAOImpl.getInstance();

    private OcupacionesServiceImpl() {}

    public static OcupacionesServiceImpl getInstance() {
        if (instance == null) {
            instance = new OcupacionesServiceImpl();
        }
        return instance;
    }

    @Override
    public Ocupaciones getByID(Integer id) {
        return (Ocupaciones) ocupacionDAO.getByID(id);
    }

    @Override
    public List<Ocupaciones> getAll() {
        return ocupacionDAO.getAll();
    }

    @Override
    public Boolean insertEntity(Ocupaciones entity) {
        return ocupacionDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(Ocupaciones entity) {
        return ocupacionDAO.save(entity);
    }

    @Override
    public Boolean delete(Ocupaciones entity) {
        return ocupacionDAO.delete(entity);
    }
}
