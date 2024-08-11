package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.GruposSanguineosDAOImpl;
import edu.unam.proyecto.avance.model.GruposSanguineos;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class GruposSanguineosServiceImpl implements GenericDAOService<GruposSanguineos, Integer> {
    private static GruposSanguineosServiceImpl instance;
    private static final GenericDAO grupoSanguineoDAO = GruposSanguineosDAOImpl.getInstance();

    private GruposSanguineosServiceImpl() {}

    public static GruposSanguineosServiceImpl getInstance() {
        if (instance == null) {
            instance = new GruposSanguineosServiceImpl();
        }
        return instance;
    }

    @Override
    public GruposSanguineos getByID(Integer id) {
        return (GruposSanguineos) grupoSanguineoDAO.getByID(id);
    }

    @Override
    public List<GruposSanguineos> getAll() {
        return grupoSanguineoDAO.getAll();
    }

    @Override
    public Boolean insertEntity(GruposSanguineos entity) {
        return grupoSanguineoDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(GruposSanguineos entity) {
        return grupoSanguineoDAO.save(entity);
    }

    @Override
    public Boolean delete(GruposSanguineos entity) {
        return grupoSanguineoDAO.save(entity);
    }
}
