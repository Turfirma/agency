package main.springmvc.controller;

import lombok.extern.log4j.Log4j;
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
@Log4j
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
        try {
            countryService.saveOrUpdate(country);
            log.info(country.getCountryName() + "was saved");
        } catch (Exception e) {log.error("Country with name " + country.getCountryName() + " are ready into DB");}
        return "redirect:/countries";
    }

    @RequestMapping(value = "/country/remove", method = RequestMethod.POST)
    public String removeCountry(@RequestParam(value = "idList") Integer[] list){
        for (Integer id: list) {
            countryService.delete(id);
            log.info("country with id= "+ id+" was deleted ");
        }
        return "redirect:/countries";
    }

    @RequestMapping("/edit/{countryId}")
    public String editCountry(@PathVariable("countryId") int countryId, Model model){
        model.addAttribute("country", countryService.findById(countryId));
        model.addAttribute("listCountries", countryService.findAll());
        return "country";
    }
}
