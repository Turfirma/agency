package main.springmvc.dao.impl;

import main.springmvc.dao.CityDAO;
import main.springmvc.model.City;
import org.springframework.stereotype.Repository;

/**
 * Implementations of city DAO.
 */
@Repository
public class CityDAOImpl extends GenericDAOImpl<City> implements CityDAO {

}
