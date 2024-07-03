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

    @GetMapping("/locations")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/locations";
    }

    @GetMapping("/locationAdd")
    public String addLocation(Model model){
        addModelAttributes(model);
        return "/parameters/locationAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/locationEdit{id}")
    public String editLocation(@PathVariable Integer id, Model model){
        addModelAttributes(model);
        model.addAttribute("location", locationService.findById(id));
        return "/parameters/locationEdit";
    }

    @GetMapping("/locationDetails{id}")
    public String detailLocation(@PathVariable Integer id, Model model){
        addModelAttributes(model);
        model.addAttribute("location", locationService.findById(id));
        return "/parameters/locationDetails";
    }

    @PostMapping("/locations")
    public String save(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @DeleteMapping(value="/location/delete/{id}")
    public String delete(@PathVariable Integer id) {
        locationService.deleteById(id);
        return "redirect:/locations";
    }


    @Bean
    public HiddenHttpMethodFilter hiddenLocationHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}