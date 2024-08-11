package edu.unam.proyecto.avance.service.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.dao.impl.DatosPersonalesGeneralesDAOImpl;
import edu.unam.proyecto.avance.dao.impl.DireccionDAOImpl;
import edu.unam.proyecto.avance.model.DatosPersonalesGenerales;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;

public class DatosPersonalesGeneralesServiceImpl implements GenericDAOService<DatosPersonalesGenerales, Integer> {

    private static DatosPersonalesGeneralesServiceImpl instance;
    private static final GenericDAO datosPersonalesDAO = DatosPersonalesGeneralesDAOImpl.getInstance();

    private DatosPersonalesGeneralesServiceImpl() {}

    public static DatosPersonalesGeneralesServiceImpl getInstance() {
        if (instance == null) {
            instance = new DatosPersonalesGeneralesServiceImpl();
        }
        return instance;
    }

    @Override
    public DatosPersonalesGenerales getByID(Integer id) {
        return (DatosPersonalesGenerales) datosPersonalesDAO.getByID(id);
    }

    @Override
    public List<DatosPersonalesGenerales> getAll() {
        return datosPersonalesDAO.getAll();
    }

    @Override
    public Boolean insertEntity(DatosPersonalesGenerales entity) {
        return datosPersonalesDAO.save(entity);
    }

    @Override
    public Boolean updateEntity(DatosPersonalesGenerales entity) {
        return datosPersonalesDAO.save(entity);
    }

    @Override
    public Boolean delete(DatosPersonalesGenerales entity) {
        return datosPersonalesDAO.delete(entity);
    }
}
