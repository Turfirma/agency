package main.springmvc.controller;

import main.springmvc.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller for operations with hotels.
 */
public class HotelController {

    @Autowired
    private CityServiceImpl cityService;

    /*@RequestMapping("/listOfCity");*/

}
