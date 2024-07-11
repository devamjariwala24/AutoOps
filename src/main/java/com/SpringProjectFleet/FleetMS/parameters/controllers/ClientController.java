package com.SpringProjectFleet.FleetMS.parameters.controllers;

import com.SpringProjectFleet.FleetMS.parameters.models.Client;
import com.SpringProjectFleet.FleetMS.parameters.models.Contact;
import com.SpringProjectFleet.FleetMS.parameters.models.Location;
import com.SpringProjectFleet.FleetMS.parameters.models.State;
import com.SpringProjectFleet.FleetMS.parameters.services.ClientService;
import com.SpringProjectFleet.FleetMS.parameters.services.CountryService;
import com.SpringProjectFleet.FleetMS.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;


    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/clients")
    public String findAllClientData(Model model){
        addModelAttributes(model);
        return "/parameters/Client/clients";
    }

    @GetMapping("/clientAdd")
    public String addClientFromClientsPage(Model model){
        addModelAttributes(model);
        return "/parameters/Client/clientAdd";
    }

    @PostMapping("/parameters/clientAdd")
    public String saveClientFromClientAddPage(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }


    @GetMapping("/clientDetails{id}")
    public String detailsClientFromClientsPage(@PathVariable Integer id, Model model){
        addModelAttributes(model);
        model.addAttribute("client", clientService.findById(id));
        return "/parameters/Client/clientDetails";
    }

    @GetMapping("/clientEdit{id}")
    public String editClientFromClientsPage(@PathVariable Integer id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("countries", countryService.findAll());
        if (client.getCountry() != null) {
            model.addAttribute("selectedCountryId", client.getCountry().getId());
        }
        if (client.getState() != null) {
            model.addAttribute("selectedStateId", client.getState().getId());
        }
        return "/parameters/Client/clientEdit";
    }


    @PostMapping(value = "/client/update/{id}")
    public String saveClientFromClientEditPage(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @DeleteMapping(value="/client/delete/{id}")
    public String delete(@PathVariable Integer id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }

    @GetMapping("/parameters/states/{countryId}")
    @ResponseBody
    public List<State> getStatesByCountry(@PathVariable Integer countryId) {
        return stateService.findByCountryId(countryId);
    }
}
