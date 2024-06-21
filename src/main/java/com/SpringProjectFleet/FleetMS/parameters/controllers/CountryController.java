package com.SpringProjectFleet.FleetMS.parameters.controllers;

import com.SpringProjectFleet.FleetMS.parameters.models.Country;
import com.SpringProjectFleet.FleetMS.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model){
        List<Country> countries = countryService.getALl();
        model.addAttribute("countries", countries);
       return "parameters/countryList";
    }

    @GetMapping("/countryAdd")
    public String addCountry(){
        return "parameters/countryAdd";
    }

    @PostMapping("/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @DeleteMapping("/countries/delete/{id}")
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }



    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}
