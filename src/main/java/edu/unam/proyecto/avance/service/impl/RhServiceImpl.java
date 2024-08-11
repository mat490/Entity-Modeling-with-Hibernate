package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.CombeDAOImpl;
import edu.unam.proyecto.avance.dao.impl.RhDAOImpl;
import edu.unam.proyecto.avance.model.Rh;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class RhServiceImpl implements GenericDAOService<Rh, Integer> {
    private static RhServiceImpl instance;
    private static final GenericDAO rhDAO = RhDAOImpl.getInstance();

    private RhServiceImpl() {}

    public static RhServiceImpl getInstance() {
        if (instance == null) {
            instance = new RhServiceImpl();
        }
        return instance;
    }

    @Override
    public Rh getByID(Integer id) {
        return (Rh) rhDAO.getByID(id);
    }

    @Override
    public List<Rh> getAll() {
        return rhDAO.getAll();
    }

    @Override
    public Boolean insertEntity(Rh entity) {
        return rhDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(Rh entity) {
        return rhDAO.save(entity);
    }

    @Override
    public Boolean delete(Rh entity) {
        return rhDAO.delete(entity);
    }
}
