package main.springmvc.service.impl;

import main.springmvc.dao.impl.CountryDAOImpl;
import main.springmvc.model.Country;
import main.springmvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementations of country services.
 */
@Service
public class CountryServiceImpl extends GenericServiceImpl<Country> implements CountryService {

    @Autowired
    public CountryServiceImpl(@Qualifier("CountryDAOImpl")CountryDAOImpl countryDAO) {
        super(countryDAO);
    }


    /*@Autowired
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
    }*/
}
