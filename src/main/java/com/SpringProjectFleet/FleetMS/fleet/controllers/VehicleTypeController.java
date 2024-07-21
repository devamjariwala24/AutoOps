package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleType;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleTypes")
    public String findAll(Model model){
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        return "/fleet/VehicleTypes/vehicleTypes";
    }

    @GetMapping("/vehicleTypeDetails{id}")
    public String detailLocation(@PathVariable Integer id, Model model){
        VehicleType vehicleType = vehicleTypeService.findById(id);
        model.addAttribute("vehicleType",vehicleType);
        return "vehicleTypeDetails";
    }

    @GetMapping("/addNewVehicleTypeRecord")
    public String vehicleTypeAddFromVehicleTypePage(){
        return "/fleet/VehicleTypes/vehicleTypeAdd";
    }

    //Add VehicleType
    @PostMapping(value="/addNewVehicleType")
    public String addNewVehicleTypeRecordFromVehicleTypeAddPage(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @DeleteMapping(value="/vehicleType/delete/{id}")
    public String deleteFromVehicleTypesPage(@PathVariable Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }

    @GetMapping("/vehicleTypeEdit{id}")
    public String editVehicleTypeFromVehicleTypePage(@PathVariable Integer id, Model model){
        VehicleType vehicleType= vehicleTypeService.findById(id);
        model.addAttribute("vehicleType", vehicleType);
        return "/fleet/VehicleTypes/vehicleTypeEdit";
    }

    @PostMapping(value = "/vehicleType/update/{id}")
    public String updateVehicleTypeFromVehicleTypeEditPage(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicleType() {
        return new HiddenHttpMethodFilter();
    }

}
