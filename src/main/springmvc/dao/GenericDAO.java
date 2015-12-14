package main.springmvc.dao;

import java.util.List;

/**
 * General DAO for all implementation.
 */
public interface GenericDAO <T> {
    void saveOrUpdate(T t);
    List<T> findAll();
    void delete(T t);
    T findById(Integer Id);

}
