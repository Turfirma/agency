package main.springmvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * General DAO implementation.
 */
public class GenericDAOImpl<T> implements GenericDAO <T> {

    private Class<T> type;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findAll() {
        return sessionFactory.getCurrentSession().createCriteria(type).list();
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findById(Integer id) {
        return (T) sessionFactory.getCurrentSession().get(type, id) ;
    }
}