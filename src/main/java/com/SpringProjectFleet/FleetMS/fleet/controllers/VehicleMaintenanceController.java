package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleMaintenance;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;

    @GetMapping("/vehicleMaintenance")
    public String findAll(Model model){
        model.addAttribute("vehicleMaintenance", vehicleMaintenanceService.findAll());
        return "/fleet/VehicleMaintenance/vehicleMaintenance";
    }

    @GetMapping("/vehicleMaintenanceDetails{id}")
    public String detailVehicleMaintenance(@PathVariable Integer id, Model model){
        VehicleMaintenance vehicleMaintenance = vehicleMaintenanceService.findById(id);
        model.addAttribute("vehicleMaintenance",vehicleMaintenance);
        return "/fleet/VehicleMaintenance/vehicleMaintenanceDetails";
    }

    @GetMapping("/addNewVehicleMaintenanceRecord")
    public String vehicleMaintenanceAddFromVehicleMaintenancePage(){
        return "/fleet/VehicleMaintenance/vehicleMaintenanceAdd";
    }

    //Add VehicleType
    @PostMapping(value="/addNewVehicleMaintenance")
    public String addNewVehicleMaintenanceRecordFromVehicleMaintenanceAddPage(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @DeleteMapping(value="/vehicleMaintenance/delete/{id}")
    public String deleteFromVehicleMaintenancePage(@PathVariable Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenance";
    }

    @GetMapping("/vehicleMaintenanceEdit{id}")
    public String editVehicleMaintenanceFromVehiclePage(@PathVariable Integer id, Model model){
        VehicleMaintenance vehicleMaintenance = vehicleMaintenanceService.findById(id);
        model.addAttribute("vehicleMaintenance", vehicleMaintenance);
        return "/fleet/VehicleMaintenance/vehicleMaintenanceEdit";
    }

    @PostMapping(value = "/vehicleMaintenance/update/{id}")
    public String updateVehicleMaintenanceFromVehicleMaintenanceEditPage(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicleMaintenance() {
        return new HiddenHttpMethodFilter();
    }

}
