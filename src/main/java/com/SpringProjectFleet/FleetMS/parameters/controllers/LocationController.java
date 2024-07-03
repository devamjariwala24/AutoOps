package com.SpringProjectFleet.FleetMS.parameters.controllers;


import com.SpringProjectFleet.FleetMS.parameters.models.Location;
import com.SpringProjectFleet.FleetMS.parameters.services.CountryService;
import com.SpringProjectFleet.FleetMS.parameters.services.LocationService;
import com.SpringProjectFleet.FleetMS.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/parameters/locations")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/locations";
    }

    @GetMapping("/parameters/locationAdd")
    public String addLocation(Model model){
        addModelAttributes(model);
        return "/parameters/locationAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/location/{op}/{id}")
    public String editLocation(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttributes(model);
        model.addAttribute("location", locationService.findById(id));
        return "/parameters/location" + op;

    }

    @PostMapping("/parameters/locations")
    public String save(Location location) {
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    @DeleteMapping(value="/location/delete/{id}")
    public String delete(@PathVariable Integer id) {
        locationService.deleteById(id);
        return "redirect:/parameters/locations";
    }


    @Bean
    public HiddenHttpMethodFilter hiddenLocationHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}