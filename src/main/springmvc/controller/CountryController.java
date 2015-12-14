package main.springmvc.controller;

import main.springmvc.model.Country;
import main.springmvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 13.12.2015
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/")
    public ModelAndView handleRequest() throws Exception {
        List<Country> listCountries = countryService.findAll();
        ModelAndView model = new ModelAndView("CountryList");
        model.addObject("countryList", listCountries);
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newCountry() {
        ModelAndView model = new ModelAndView("CountryForm");
        model.addObject("country", new Country());
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editCountry(HttpServletRequest request) {
        Integer countryId = Integer.parseInt(request.getParameter("countryId"));
        Country country = countryService.findById(countryId);
        ModelAndView model = new ModelAndView("CountryForm");
        model.addObject("country", country);
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteCountry(HttpServletRequest request) {
        Integer countryId = Integer.parseInt(request.getParameter("countryId"));
        countryService.deleteCountry(countryId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveCountry(@ModelAttribute Country country) {
        countryService.saveOrUpdate(country);
        return new ModelAndView("redirect:/");
    }

}
