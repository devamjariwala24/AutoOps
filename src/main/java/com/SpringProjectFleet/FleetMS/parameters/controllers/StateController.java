package com.SpringProjectFleet.FleetMS.parameters.controllers;

import com.SpringProjectFleet.FleetMS.parameters.models.State;
import com.SpringProjectFleet.FleetMS.parameters.services.CountryService;
import com.SpringProjectFleet.FleetMS.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class StateController {
    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    public  Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }


    @GetMapping("/states")
    public String findAll(Model model){
        addModelAttribute(model);
        return "/parameters/states";
    }

    @GetMapping("/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @GetMapping("/stateDetails{id}")
    public String detailsState(@PathVariable Integer id, Model model){
        State state = stateService.findById(id);
        model.addAttribute("state", state);
        return "parameters/stateDetails";
    }

    @GetMapping("/stateEdit{id}")
    public String editState(@PathVariable Integer id, Model model){
        State state = stateService.findById(id);
        model.addAttribute("state", state);
        return "parameters/stateEdit";
    }

    @PostMapping("/states")
    public String saveState(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @DeleteMapping(value="/states/delete/{id}")
    public String delete(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/states";
    }

    @Bean
    public HiddenHttpMethodFilter hiddenStateHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


}
