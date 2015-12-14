package main.springmvc.dao;

import main.springmvc.model.City;

import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 12.12.2015
 */
public interface CityDAO {
    void addCity(City city);
    List<City> findAll();
    void deleteCity(Integer cityId);
}
