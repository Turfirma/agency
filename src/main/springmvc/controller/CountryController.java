package main.springmvc.controller;

import main.springmvc.model.Country;
import main.springmvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for operations with countries.
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
     public String listCountries(Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("listCountries", countryService.findAll());
        return "country";
    }

    @RequestMapping(value = "/country/add", method = RequestMethod.POST)
    public String addCountry(@ModelAttribute Country country) {
        List<Country> list = countryService.findAll();
        for (Country countryList : list){
            if (countryList.equals(country)) countryService.saveOrUpdate(country);
        }
        return "redirect:/countries";
    }

    @RequestMapping(value = "/country/remove", method = RequestMethod.POST)
    public String removePerson(@RequestParam(value = "idList") Integer[] list){
        for (Integer id: list) {
            countryService.delete(id);
        }
        return "redirect:/countries";
    }

    @RequestMapping("/edit/{countryId}")
    public String editPerson(@PathVariable("countryId") int countryId, Model model){
        model.addAttribute("country", countryService.findById(countryId));
        model.addAttribute("listCountries", countryService.findAll());
        return "country";
    }
}
