package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleModel;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicleModel")
    public String findAll(Model model){
        model.addAttribute("vehicleModel", vehicleModelService.findAll());
        return "/fleet/VehicleModel/vehicleModel";
    }

    @GetMapping("/vehicleModelDetails{id}")
    public String detailVehicleModel(@PathVariable Integer id, Model model){
        VehicleModel vehicleModel = vehicleModelService.findById(id);
        model.addAttribute("vehicleModel",vehicleModel);
        return "/fleet/VehicleModel/vehicleModelDetails";
    }

    @GetMapping("/addNewVehicleModelRecord")
    public String vehicleModelAddFromVehicleModelPage(){
        return "/fleet/VehicleModel/vehicleModelAdd";
    }

    //Add VehicleType
    @PostMapping(value="/addNewVehicleModel")
    public String addNewVehicleModelRecordFromVehicleModelAddPage(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    @DeleteMapping(value="/vehicleModel/delete/{id}")
    public String deleteFromVehicleModelPage(@PathVariable Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicleModel";
    }

    @GetMapping("/vehicleModelEdit{id}")
    public String editVehicleModelFromVehiclePage(@PathVariable Integer id, Model model){
        VehicleModel vehicleModel = vehicleModelService.findById(id);
        model.addAttribute("vehicleModel", vehicleModel);
        return "/fleet/VehicleModel/vehicleModelEdit";
    }

    @PostMapping(value = "/vehicleModel/update/{id}")
    public String updateVehicleModelFromVehicleModelEditPage(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicleModel() {
        return new HiddenHttpMethodFilter();
    }

}
