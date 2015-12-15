package main.springmvc.service;

import java.util.List;

/**
 * General interface for all entities interfaces.
 */
public interface GenericService <T> {
    void saveOrUpdate(T t);
    List<T> findAll();
    void delete(Integer id);
    T findById(Integer id);
}
