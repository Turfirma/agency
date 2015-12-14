package main.springmvc.dao;

import main.springmvc.model.City;
import main.springmvc.model.Country;

import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 12.12.2015
 */
public interface CountryDAO {
    void saveOrUpdate(Country country);
    List<Country> findAll();
    void deleteCountry(Integer countryId);
    Country findById(Integer countryId);
}
