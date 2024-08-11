package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.CombeDAOImpl;
import edu.unam.proyecto.avance.dao.impl.PacientesDAOImpl;
import edu.unam.proyecto.avance.model.Pacientes;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class PacientesServiceImpl implements GenericDAOService<Pacientes, Integer> {

    private static PacientesServiceImpl instance;
    private static final GenericDAO pacienteDAO = PacientesDAOImpl.getInstance();

    private PacientesServiceImpl() {}

    public static PacientesServiceImpl getInstance() {
        if (instance == null) {
            instance = new PacientesServiceImpl();
        }
        return instance;
    }

    @Override
    public Pacientes getByID(Integer id) {
        return (Pacientes) pacienteDAO.getByID(id);
    }

    @Override
    public List<Pacientes> getAll() {
        return pacienteDAO.getAll();
    }

    @Override
    public Boolean insertEntity(Pacientes entity) {
        return pacienteDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(Pacientes entity) {
        return pacienteDAO.save(entity);
    }

    @Override
    public Boolean delete(Pacientes entity) {
        return pacienteDAO.delete(entity);
    }
}
