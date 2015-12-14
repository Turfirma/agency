package main.springmvc.service;

import main.springmvc.dao.CityDAO;
import main.springmvc.model.City;
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
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Transactional
    public void addCity(City city) {
        cityDAO.addCity(city);
    }

    @Transactional
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Transactional
    public void deleteCity(Integer idCity) {
        cityDAO.deleteCity(idCity);
    }
}
