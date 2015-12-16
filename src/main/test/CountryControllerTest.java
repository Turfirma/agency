package main.test;

import main.springmvc.controller.CountryController;
import main.springmvc.model.Country;
import main.springmvc.service.CountryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 16.12.2015
 */
public class CountryControllerTest {
    @Mock
    CountryService countryService;

    @InjectMocks
    CountryController countryController;

    @Spy
    List<Country> countries = new ArrayList<>();

    @Spy
    Model model = new ExtendedModelMap();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        countries = getCountries();
    }

    @Test
    public void listCountries() {
        when(countryService.findAll()).thenReturn(countries);
        Assert.assertEquals(countryController.listCountries(model), "country");
        Assert.assertEquals(model.asMap().get("listCountries"), countries);
        verify(countryService, Mockito.atLeastOnce()).findAll();
    }

    @Test
    public void addCountry() {
        Assert.assertEquals(countryController.addCountry(countries.get(0)),"redirect:/countries");
    }

    @Test
    public void removeCountry() {
        doNothing().when(countryService).delete(anyInt());
        Assert.assertEquals(countryController.removeCountry(new Integer[1]),"redirect:/countries");
    }

    public List<Country> getCountries() {
        Country country = new Country();
        country.setCountryId(1);
        country.setCountryName("USA");
        countries.add(country);
        return countries;
    }
}
