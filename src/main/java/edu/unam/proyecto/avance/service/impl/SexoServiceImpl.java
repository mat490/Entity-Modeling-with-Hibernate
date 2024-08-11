package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.SexoDAOImpl;
import edu.unam.proyecto.avance.model.Sexo;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class SexoServiceImpl implements GenericDAOService<Sexo, Integer> {

    private static SexoServiceImpl instance;
    private static final GenericDAO sexoDAO = SexoDAOImpl.getInstance();

    private SexoServiceImpl() {}

    public static SexoServiceImpl getInstance() {
        if (instance == null) {
            instance = new SexoServiceImpl();
        }
        return instance;
    }

    @Override
    public Sexo getByID(Integer id) {
        return (Sexo) sexoDAO.getByID(id);
    }

    @Override
    public List<Sexo> getAll() {
        return sexoDAO.getAll();
    }

    @Override
    public Boolean insertEntity(Sexo entity) {
        return sexoDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(Sexo entity) {
        return sexoDAO.save(entity);
    }

    @Override
    public Boolean delete(Sexo entity) {
        return sexoDAO.delete(entity);
    }
}
