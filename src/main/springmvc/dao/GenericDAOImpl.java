package main.springmvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * General DAO implementation.
 */
public class GenericDAOImpl <T> implements GenericDAO <T> {

    private Class<T> type;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findAll() {
         List<T> list = sessionFactory.getCurrentSession().createCriteria(type).list();
        return list;
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public T findById(Integer Id) {
        return (T) sessionFactory.getCurrentSession().get(type, Id) ;
    }
}
