package main.springmvc.controller;

import main.springmvc.model.City;
import main.springmvc.model.Country;
import main.springmvc.service.CityService;
import main.springmvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for operations with cities.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String listCities(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("country", new Country());
        model.addAttribute("listCities", cityService.findAll());
        model.addAttribute("listCountries", countryService.findAll());
        return "city";
    }

    @RequestMapping(value = "/city/add", method = RequestMethod.POST)
    public String addCity(@ModelAttribute City city, @ModelAttribute Country country) {
        city.setCountry(country);
        cityService.saveOrUpdate(city);
        return "redirect:/cities";
    }

    @RequestMapping(value = "/city/remove", method = RequestMethod.POST)
    public String removeCity(@RequestParam(value = "idList") Integer[] list) {
        for (Integer id : list) {
            cityService.delete(id);
        }
        return "redirect:/cities";
    }

    @RequestMapping("/city/edit/{cityId}")
    public String editCountry(@PathVariable("cityId") int cityId, Model model) {
        model.addAttribute("city", cityService.findById(cityId));
        model.addAttribute("listCountries", countryService.findAll());
        return "city";
    }
}
