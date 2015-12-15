package main.springmvc.dao.impl;

import main.springmvc.dao.CountryDAO;
import main.springmvc.model.Country;
import org.springframework.stereotype.Repository;

/**
 *Implementations of country DAO.
 */
@Repository
public class CountryDAOImpl extends GenericDAOImpl<Country> implements CountryDAO {

}
