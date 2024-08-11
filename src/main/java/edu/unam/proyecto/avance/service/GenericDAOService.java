package edu.unam.proyecto.avance.service;

import java.util.List;

public interface GenericDAOService<T, ID> {
    T getByID(ID id);
    List<T> getAll();
    Boolean insertEntity(T entity);
    Boolean updateEntity(T entity);
    Boolean delete(T entity);

}
