package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.DireccionDAOImpl;
import edu.unam.proyecto.avance.model.Direccion;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class DireccionServiceImpl implements GenericDAOService<Direccion, Integer> {

    private static DireccionServiceImpl instance;
    private static final GenericDAO direccionDAO = DireccionDAOImpl.getInstance();

    private DireccionServiceImpl() {}

    public static DireccionServiceImpl getInstance() {
        if (instance == null) {
            instance = new DireccionServiceImpl();
        }
        return instance;
    }

    @Override
    public Direccion getByID(Integer id) {
        return (Direccion) direccionDAO.getByID(id);
    }

    @Override
    public List<Direccion> getAll() {
        return direccionDAO.getAll();
    }

    @Override
    public Boolean insertEntity(Direccion entity) {
        return direccionDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(Direccion entity) {
        return direccionDAO.save(entity);
    }

    @Override
    public Boolean delete(Direccion entity) {
        return direccionDAO.delete(entity);
    }
}
