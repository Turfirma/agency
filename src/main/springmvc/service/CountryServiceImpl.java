package main.springmvc.service;

import main.springmvc.dao.CountryDAOImpl;
import main.springmvc.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 12.12.2015
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
    public void deleteCountry(Integer idCountry) {
        countryDAO.delete(findById(idCountry));
    }

    @Transactional
    public Country findById(Integer countryId) {
        return  countryDAO.findById(countryId);
    }
}
