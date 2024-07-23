package com.SpringProjectFleet.FleetMS.fleet.controllers;


import com.SpringProjectFleet.FleetMS.fleet.models.VehicleHire;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleHireService;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleService;
import com.SpringProjectFleet.FleetMS.parameters.services.ClientService;
import com.SpringProjectFleet.FleetMS.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class VehicleHireController {

    @Autowired private VehicleHireService vehicleHireService;
    @Autowired private ClientService clientService;
    @Autowired private LocationService locationService;
    @Autowired private VehicleService vehicleService;

    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("vehicles", vehicleService.findAll());
        return model;
    }

    @GetMapping("/vehicleHire")
    public String findAll(Model model){
        model.addAttribute("vehicleHires", vehicleHireService.findAll());
        addModelAttributes(model);
        return "/fleet/VehicleHire/vehicleHires";
    }

    @GetMapping("/vehicleHireDetails{id}")
    public String detailVehicleHire(@PathVariable Integer id, Model model){
        VehicleHire vehicleHire = vehicleHireService.findById(id);
        model.addAttribute("vehicleHire",vehicleHire);
        addModelAttributes(model);
        return "/fleet/VehicleHire/vehicleHireDetails";
    }

    @GetMapping("/addNewVehicleHireRecord")
    public String vehicleHireAddFromVehicleHirePage(Model model){
        addModelAttributes(model);
        return "/fleet/VehicleHire/vehicleHireAdd";
    }

    //Add VehicleType
    @PostMapping(value="/addNewVehicleHire")
    public String addNewVehicleHireRecordFromVehicleHireAddPage(VehicleHire vehicleHire, Model model) {
        vehicleHireService.save(vehicleHire);
        addModelAttributes(model);
        return "redirect:/vehicleHire";
    }

    @DeleteMapping(value="/vehicleHire/delete/{id}")
    public String deleteFromVehicleHirePage(@PathVariable Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHire";
    }

    @GetMapping("/vehicleHireEdit{id}")
    public String editVehicleHireFromVehiclePage(@PathVariable Integer id, Model model){
        VehicleHire vehicleHire = vehicleHireService.findById(id);
        model.addAttribute("vehicleHire", vehicleHire);
        addModelAttributes(model);
        return "/fleet/VehicleHire/vehicleHireEdit";
    }

    @PostMapping(value = "/vehicleHire/update/{id}")
    public String updateVehicleHireFromVehicleHireEditPage(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHire";
    }


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicleHire() {
        return new HiddenHttpMethodFilter();
    }

}
