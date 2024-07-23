package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.Vehicle;
import com.SpringProjectFleet.FleetMS.fleet.services.*;
import com.SpringProjectFleet.FleetMS.hr.services.EmployeeService;
import com.SpringProjectFleet.FleetMS.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;



@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private EmployeeService employeeService ;

    @Autowired
    private VehicleStatusService vehicleStatusService;


    public Model addModelAttributes(Model model){
        model.addAttribute("vehicles", vehicleService.findAll());
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vehicleStatuses", vehicleStatusService.findAll());
        return model;
    }

    @GetMapping("/vehicles")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/fleet/Vehicle/vehicles";
    }

    @GetMapping("/vehicleDetails{id}")
    public String detailVehicles(@PathVariable Integer id, Model model){
        Vehicle vehicle = vehicleService.findById(id);
        model.addAttribute("vehicle",vehicle);
        addModelAttributes(model);
        return "/fleet/Vehicle/vehicleDetails";
    }

    @GetMapping("/addNewVehicleRecord")
    public String vehicleAddFromVehiclePage(Model model){
        addModelAttributes(model);
        return "/fleet/Vehicle/vehicleAdd";
    }

    //Add VehicleType
    @PostMapping(value="/addNewVehicle")
    public String addNewVehicleRecordFromVehicleAddPage(Vehicle vehicle, Model model) {
        vehicleService.save(vehicle);
        addModelAttributes(model);
        return "redirect:/vehicles";
    }

    @DeleteMapping(value="/vehicle/delete/{id}")
    public String deleteFromVehiclePage(@PathVariable Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicleEdit{id}")
    public String editVehicleFromVehiclePage(@PathVariable Integer id, Model model){
        Vehicle vehicle = vehicleService.findById(id);
        model.addAttribute("vehicle", vehicle);
        addModelAttributes(model);
        return "/fleet/Vehicle/vehicleEdit";
    }

    @PostMapping(value = "/vehicle/update/{id}")
    public String updateVehicleFromVehicleEditPage(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicles() {
        return new HiddenHttpMethodFilter();
    }

}
