package main.springmvc.service.impl;

import main.springmvc.dao.impl.CityDAOImpl;
import main.springmvc.model.City;
import main.springmvc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementations of city services.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAOImpl cityDAO;

    @Transactional
    public void saveOrUpdate(City city) {
        cityDAO.saveOrUpdate(city);
    }

    @Transactional
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Transactional
    public void delete(Integer idCity) {
        cityDAO.delete(findById(idCity));
    }

    @Override
    public City findById(Integer idCity) {
        return (City) cityDAO.findById(idCity);
    }


}
