package main.springmvc.service.impl;

import main.springmvc.dao.GenericDAO;
import main.springmvc.service.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Максим on 16.12.2015.
 */
public class GenericServiceImpl<T> implements GenericService <T> {

    GenericDAO genericDAO;

    public GenericServiceImpl(GenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public GenericServiceImpl() {
    }

    @Transactional
    public void saveOrUpdate(T t) {
        genericDAO.saveOrUpdate(t);
    }

    @Transactional
    public List<T> findAll() {
        return genericDAO.findAll();
    }

    @Transactional
    public void delete(Integer id) {
        genericDAO.delete(findById(id));
    }

    @Transactional
    public T findById(Integer id) {
        return (T) genericDAO.findById(id);
    }
}
