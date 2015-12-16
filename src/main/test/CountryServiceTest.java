package main.test;

import main.springmvc.dao.CountryDAO;
import main.springmvc.model.Country;
import main.springmvc.service.CountryService;
import main.springmvc.service.impl.CountryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 16.12.2015
 */
public class CountryServiceTest {

    @Mock
    CountryDAO countryDAO;

    @InjectMocks
    CountryServiceImpl countryService;

    @Spy
    List<Country> countries = new ArrayList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        countries = getCountries();
    }

    @Test
    public void findById() {
        Country country = countries.get(0);
        when(countryDAO.findById(anyInt())).thenReturn(country);
        Assert.assertEquals(countryService.findById(country.getCountryId()),country);
    }

    @Test
    public void saveOrUpdate() {
        doNothing().when(countryDAO).saveOrUpdate(any(Country.class));
        countryService.saveOrUpdate(any(Country.class));
        verify(countryDAO, atLeastOnce()).saveOrUpdate(any(Country.class));
    }

    @Test
    public void delete() {
        doNothing().when(countryDAO).delete(any(Country.class));
        countryService.delete(anyInt());
        verify(countryDAO,atLeastOnce()).delete(any(Country.class));
    }

    @Test
    public void findAll() {
        when(countryDAO.findAll()).thenReturn(countries);
        Assert.assertEquals(countryService.findAll(),countries);
    }

    public List<Country> getCountries() {
        Country country = new Country();
        country.setCountryId(1);
        country.setCountryName("USA");
        countries.add(country);
        return countries;
    }
}


