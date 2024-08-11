package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.CombeDAOImpl;
import edu.unam.proyecto.avance.model.Combe;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class CombeServiceImpl implements GenericDAOService<Combe, Integer> {
    private static CombeServiceImpl instance;
    private static final GenericDAO combeDAO = CombeDAOImpl.getInstance();

    private CombeServiceImpl() {}

    public static CombeServiceImpl getInstance() {
        if (instance == null) {
            instance = new CombeServiceImpl();
        }
        return instance;
    }
    @Override
    public Combe getByID(Integer id) {
        return (Combe) combeDAO.getByID(id);
    }

    @Override
    public List<Combe> getAll() {
        return combeDAO.getAll();
    }

    @Override
    public Boolean insertEntity(Combe entity) {
        return combeDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(Combe entity) {
        return combeDAO.save(entity);
    }

    @Override
    public Boolean delete(Combe entity) {
        return combeDAO.delete(entity);
    }
}
