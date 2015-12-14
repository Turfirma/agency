package main.springmvc.service;

import main.springmvc.model.Country;

import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 12.12.2015
 */
public interface CountryService {
    void saveOrUpdate(Country country);
    List<Country> findAll();
    void deleteCountry(Integer idCountry);
    Country findById(Integer idCountry);
}
