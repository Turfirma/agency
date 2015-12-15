package main.springmvc.service.impl;

import main.springmvc.dao.impl.CountryDAOImpl;
import main.springmvc.model.Country;
import main.springmvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementations of country services.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAOImpl countryDAO;

    @Transactional
    public void saveOrUpdate(Country country) {
        countryDAO.saveOrUpdate(country);
    }

    @Transactional
    public List<Country> findAll() {
        return countryDAO.findAll();
    }

    @Transactional
    public void delete(Integer countryId) {
        countryDAO.delete(findById(countryId));
    }

    @Transactional
    public Country findById(Integer countryId) {
        return  countryDAO.findById(countryId);
    }
}
