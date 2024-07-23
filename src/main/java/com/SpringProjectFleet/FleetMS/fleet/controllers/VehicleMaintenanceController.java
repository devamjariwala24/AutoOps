package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleMaintenance;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleMaintenanceService;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleService;
import com.SpringProjectFleet.FleetMS.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.ArrayList;
import java.util.List;


@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private SupplierService supplierService;

    public Model addModelAttributes(Model model){
        model.addAttribute("vehicles", vehicleService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("vehicleMaintenance", vehicleMaintenanceService.findAll());
        return model;
    }

    @GetMapping("/vehicleMaintenance")
    public String findAll(Model model){
        List<VehicleMaintenance> vehicleMaintenanceList = new ArrayList<>();
        // Populate the list with data
        model.addAttribute("vehicleMaintenanceList", vehicleMaintenanceList);
        addModelAttributes(model);
        return "/fleet/VehicleMaintenance/vehicleMaintenance";
    }

    @GetMapping("/vehicleMaintenanceDetails{id}")
    public String detailVehicleMaintenance(@PathVariable Integer id, Model model){
        VehicleMaintenance vehicleMaintenance = vehicleMaintenanceService.findById(id);
        model.addAttribute("vehicleMaintenance",vehicleMaintenance);
        addModelAttributes(model);
        return "/fleet/VehicleMaintenance/vehicleMaintenanceDetails";
    }

    @GetMapping("/addNewVehicleMaintenanceRecord")
    public String vehicleMaintenanceAddFromVehicleMaintenancePage(Model model){
        addModelAttributes(model);
        return "/fleet/VehicleMaintenance/vehicleMaintenanceAdd";
    }

    @PostMapping(value="/addNewVehicleMaintenance")
    public String addNewVehicleHireRecordFromVehicleHireAddPage(VehicleMaintenance vehicleMaintenance, Model model) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        addModelAttributes(model);
        return "redirect:/vehicleMaintenance";
    }

    @DeleteMapping(value="/vehicleMaintenance/delete/{id}")
    public String deleteFromVehicleMaintenancePage(@PathVariable Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenance";
    }

    @GetMapping("/vehicleMaintenanceEdit{id}")
    public String editVehicleMaintenanceFromVehicleMaintenancePage(@PathVariable Integer id, Model model){
        VehicleMaintenance vehicleMaintenance = vehicleMaintenanceService.findById(id);
        model.addAttribute("vehicleMaintenance", vehicleMaintenance);
        addModelAttributes(model);
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
