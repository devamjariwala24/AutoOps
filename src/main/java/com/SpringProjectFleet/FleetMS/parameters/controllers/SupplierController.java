package com.SpringProjectFleet.FleetMS.parameters.controllers;

import com.SpringProjectFleet.FleetMS.parameters.models.Client;
import com.SpringProjectFleet.FleetMS.parameters.models.State;
import com.SpringProjectFleet.FleetMS.parameters.models.Supplier;
import com.SpringProjectFleet.FleetMS.parameters.services.ClientService;
import com.SpringProjectFleet.FleetMS.parameters.services.CountryService;
import com.SpringProjectFleet.FleetMS.parameters.services.StateService;
import com.SpringProjectFleet.FleetMS.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/suppliers")
    public String findAllClientData(Model model){
        addModelAttributes(model);
        return "/parameters/Supplier/suppliers";
    }

    @GetMapping("/supplierAdd")
    public String addClientFromClientsPage(Model model){
        addModelAttributes(model);
        return "/parameters/Supplier/supplierAdd";
    }

    @PostMapping("/parameters/supplierAdd")
    public String saveClientFromClientAddPage(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/supplierDetails{id}")
    public String detailsClientFromClientsPage(@PathVariable Integer id, Model model){
        addModelAttributes(model);
        model.addAttribute("supplier", supplierService.findById(id));
        return "/parameters/Supplier/supplierDetails";
    }

    @GetMapping("/supplierEdit{id}")
    public String editClientFromClientsPage(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        model.addAttribute("countries", countryService.findAll());
        if (supplier.getCountry() != null) {
            model.addAttribute("selectedCountryId", supplier.getCountry().getId());
        }
        if (supplier.getState() != null) {
            model.addAttribute("selectedStateId", supplier.getState().getId());
        }
        return "/parameters/Supplier/supplierEdit";
    }


    @PostMapping(value = "/supplier/update/{id}")
    public String saveClientFromClientEditPage(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @DeleteMapping(value="/supplier/delete/{id}")
    public String delete(@PathVariable Integer id) {
        supplierService.deleteById(id);
        return "redirect:/suppliers";
    }


    @Bean
    public HiddenHttpMethodFilter hiddenSupplierHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}
