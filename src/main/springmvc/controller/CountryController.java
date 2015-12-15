package main.springmvc.controller;

import main.springmvc.model.Country;
import main.springmvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value= "/country/add", method = RequestMethod.POST)
    public String addCountry(@ModelAttribute Country country) {
        countryService.saveOrUpdate(country);
        return "redirect:/countries";
    }

    @RequestMapping("/remove/{countryId}")
    public String removePerson(@PathVariable("countryId") int countryId){
        countryService.delete(countryId);
        return "redirect:/countries";
    }

    @RequestMapping("/edit/{countryId}")
    public String editPerson(@PathVariable("countryId") int countryId, Model model){
        model.addAttribute("country", countryService.findById(countryId));
        model.addAttribute("listCountries", countryService.findAll());
        return "country";
    }
}
