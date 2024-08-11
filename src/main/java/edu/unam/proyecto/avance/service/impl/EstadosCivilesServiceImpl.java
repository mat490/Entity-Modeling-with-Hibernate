package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.DireccionDAOImpl;
import edu.unam.proyecto.avance.dao.impl.EstadosCivilesDAOImpl;
import edu.unam.proyecto.avance.model.EstadosCiviles;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class EstadosCivilesServiceImpl implements GenericDAOService<EstadosCiviles, Integer> {
    private static EstadosCivilesServiceImpl instance;
    private static final GenericDAO estadoCivilDAO = EstadosCivilesDAOImpl.getInstance();

    private EstadosCivilesServiceImpl() {}

    public static EstadosCivilesServiceImpl getInstance() {
        if (instance == null) {
            instance = new EstadosCivilesServiceImpl();
        }
        return instance;
    }

    @Override
    public EstadosCiviles getByID(Integer id) {
        return (EstadosCiviles) estadoCivilDAO.getByID(id);
    }

    @Override
    public List<EstadosCiviles> getAll() {
        return estadoCivilDAO.getAll();
    }

    @Override
    public Boolean insertEntity(EstadosCiviles entity) {
        return estadoCivilDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(EstadosCiviles entity) {
        return estadoCivilDAO.save(entity);
    }

    @Override
    public Boolean delete(EstadosCiviles entity) {
        return estadoCivilDAO.delete(entity);
    }
}
