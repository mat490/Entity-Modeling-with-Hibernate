package edu.unam.proyecto.avance.dao;

import java.util.List;

public interface GenericDAO <T, ID>{
    List<T> getAll();
    T getByID(ID id);
    Boolean delete(T entity);
    Boolean save(T entity);
}
