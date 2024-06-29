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

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @GetMapping("/parameters/state/{op}/{id}")
    public String editState(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttribute(model);
        model.addAttribute("state", stateService.findById(id));
        return "/parameters/state" + op;
    }

    @PostMapping(value="/parameters/states")
    public String addNew(State state) {
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
