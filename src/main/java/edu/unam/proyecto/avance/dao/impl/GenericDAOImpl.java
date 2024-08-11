package edu.unam.proyecto.avance.dao.impl;

import edu.unam.proyecto.avance.dao.GenericDAO;
import edu.unam.proyecto.avance.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDAOImpl <T,ID extends Serializable> implements GenericDAO<T, ID> {
    SessionFactory sessionFactory;
    Session session;

    @Override
    public List<T> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> entityList = null;
        try {
            // Iniciar en transacción
            session.beginTransaction();
            // LLenamos la lista
            entityList = session.createQuery("SELECT e FROM "+ findEntityClass().getName()+ " e" ).getResultList();
            // Realizamos el commit
            session.getTransaction().commit();
            // Se cierra la session hibernate
            session.close();
        } catch (Exception ex){
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                System.out.println("Fallo al hacer un rollback=" + exc);
            }
            throw ex;
        }
        return entityList;
    }

    @Override
    public T getByID(ID id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T entity = null;
        try {
            // Iniciar en transacción
            session.beginTransaction();
            // LLenamos la lista
            entity = (T) session.get(findEntityClass(), id);
            // Realizamos el commit
            session.getTransaction().commit();
            // Se cierra la session hibernate
            session.close();
        } catch (Exception ex){
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                System.out.println("Fallo al hacer un rollback=" + exc);
            }
            throw ex;
        }

        return entity;
    }

    @Override
    public Boolean delete(T entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Iniciamos la transacción
            session.beginTransaction();
            // Borramos la entidad
            session.remove(entity);
            // Realizamos el commit
            session.getTransaction().commit();
            // Se cierra la session hibernate
            session.close();
            return true;
        } catch (Exception ex){
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception e){
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
            }
        }
        return false;
    }

    @Override
    public Boolean save(T entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Se inicia la transaccion
            session.beginTransaction();
            // Se guarda la entidad
            session.merge(entity);
            // Se realiza el commit
            session.getTransaction().commit();
            // Se cierra la session hibernate
            session.close();
            return true;
        } catch (Exception ex){
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                System.out.println("Fallo al hacer un rollback=" + exc);
            }
            throw ex;
        }
    }

    public final Class<T> findEntityClass() {
        // ParameterizedType esta clase nos permite representar genericos obteniendo la información de los genericos en tiempo de ejecución
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        // Type es una representación abstracta de los diferentes tipos que pueden existir en Java
        // For each para cada argumento de tipo <T, ID> de la clase generica
        for (Type type : genericSuperClass.getActualTypeArguments()) {
            // Si el argumento de tipo es una intancia de nuestra superclase generica
            if (type instanceof ParameterizedType) {
                // Se devuelve la clase base de nuestro argumento de tipo
                return (Class<T>)((ParameterizedType) type).getRawType();
            } else if (type instanceof Class<?>) {
                // Si el argumento de tipo no es una clase parametrizada se hace un casteo a la clase de nuestra entidad y se devuelve
                return (Class<T>)type;
            }
        }
        return null;
    }
}
