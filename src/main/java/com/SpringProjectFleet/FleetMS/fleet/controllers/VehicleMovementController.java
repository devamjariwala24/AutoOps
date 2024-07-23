package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleMovement;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleMovementService;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleService;
import com.SpringProjectFleet.FleetMS.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private VehicleService vehicleService;

    public Model addModelAttributes(Model model){
        model.addAttribute("locations1", locationService.findAll());
        model.addAttribute("locations2", locationService.findAll());
        model.addAttribute("vehicles", vehicleService.findAll());
        return  model;
    }

    @GetMapping("/vehicleMovement")
    public String findAll(Model model) {
        model.addAttribute("vehicleMovement", vehicleMovementService.findAll());
        addModelAttributes(model);
        return "/fleet/VehicleMovement/vehicleMovement";
    }

    @GetMapping("/vehicleMovementDetails{id}")
    public String detailVehicleMovement(@PathVariable Integer id, Model model) {
        VehicleMovement vehicleMovement = vehicleMovementService.findById(id);
        model.addAttribute("vehicleMovement", vehicleMovement);
        return "/fleet/VehicleMovement/vehicleMovementDetails";
    }

    @GetMapping("/addNewVehicleMovementRecord")
    public String vehicleMovementAddFromVehicleMovementPage(Model model) {
        addModelAttributes(model);
        return "/fleet/VehicleMovement/vehicleMovementAdd";
    }

    @PostMapping(value = "/addNewVehicleMovement")
    public String addNewVehicleMovementRecordFromVehicleMovementAddPage(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @DeleteMapping(value = "/vehicleMovement/delete/{id}")
    public String deleteFromVehicleMovementPage(@PathVariable Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovement";
    }

    @GetMapping("/vehicleMovementEdit{id}")
    public String editVehicleMovementFromVehiclePage(@PathVariable Integer id, Model model) {
        VehicleMovement vehicleMovement = vehicleMovementService.findById(id);
        model.addAttribute("vehicleMovement", vehicleMovement);
        addModelAttributes(model);
        return "/fleet/VehicleMovement/vehicleMovementEdit";
    }

    @PostMapping(value = "/vehicleMovement/update/{id}")
    public String updateVehicleMovementFromVehicleMovementEditPage(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicleMovement() {
        return new HiddenHttpMethodFilter();
    }
}
