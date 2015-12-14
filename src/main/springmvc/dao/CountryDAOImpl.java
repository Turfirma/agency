package main.springmvc.dao;

import main.springmvc.model.Country;
import org.hibernate.Query;
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
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrUpdate(Country country) {
        sessionFactory.getCurrentSession().saveOrUpdate(country);
    }

    @SuppressWarnings("unchecked")
    public List<Country> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Country").list();
    }

    public void deleteCountry(Integer countryId) {
        Country country = findById(countryId);
        if (country != null) {
            sessionFactory.getCurrentSession().delete(country);
        }
    }

    public Country findById(Integer countryId) {
        Country country =(Country) sessionFactory.getCurrentSession().get(Country.class, countryId);
      /*  String hql = "from Country where id=" + countryId;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        @SuppressWarnings("unchecked")
        List<Country> listCountry = (List<Country>) query.list();
        if (listCountry != null && !listCountry.isEmpty()) {
            return listCountry.get(0);
        }*/
        return country;
    }
}
