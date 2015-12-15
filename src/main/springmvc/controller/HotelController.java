package main.springmvc.controller;

import main.springmvc.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Максим on 14.12.2015.
 */
public class HotelController {

    @Autowired
    private CityServiceImpl cityService;

    /*@RequestMapping("/listOfCity");*/

}
