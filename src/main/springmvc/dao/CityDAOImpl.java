package main.springmvc.dao;

import main.springmvc.model.City;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 12.12.2015
 */
@Repository
public class CityDAOImpl implements CityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCity(City city) {
        sessionFactory.getCurrentSession().save(city);
    }

    @SuppressWarnings("unchecked")
    public List<City> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from City").list();
    }

    public void deleteCity(Integer cityId) {
        City city = (City) sessionFactory.getCurrentSession().load(City.class, cityId);
        if (city != null) {
            sessionFactory.getCurrentSession().delete(city);
        }
    }
}
