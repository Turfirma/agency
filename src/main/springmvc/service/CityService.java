package main.springmvc.service;

import main.springmvc.model.City;

import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 12.12.2015
 */
public interface CityService {
    void addCity(City city);
    List<City> findAll();
    void deleteCity(Integer idCity);
    City findById(Integer idCity);
}
