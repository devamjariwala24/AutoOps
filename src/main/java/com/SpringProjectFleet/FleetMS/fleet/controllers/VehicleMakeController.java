package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleMake;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMake")
    public String findAll(Model model){
        model.addAttribute("vehicleMake", vehicleMakeService.findAll());
        return "/fleet/VehicleMake/vehicleMake";
    }

    @GetMapping("/vehicleMakeDetails{id}")
    public String detailVehicleMake(@PathVariable Integer id, Model model){
        VehicleMake vehicleMake = vehicleMakeService.findById(id);
        model.addAttribute("vehicleMake",vehicleMake);
        return "/fleet/VehicleMake/vehicleMakeDetails";
    }

    @GetMapping("/addNewVehicleMakeRecord")
    public String vehicleMakeAddFromVehicleMakePage(){
        return "/fleet/VehicleMake/vehicleMakeAdd";
    }

    //Add VehicleType
    @PostMapping(value="/addNewVehicleMake")
    public String addNewVehicleMakeRecordFromVehicleMakeAddPage(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @DeleteMapping(value="/vehicleMake/delete/{id}")
    public String deleteFromVehicleMakePage(@PathVariable Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMake";
    }

    @GetMapping("/vehicleMakeEdit{id}")
    public String editVehicleMakeFromVehiclePage(@PathVariable Integer id, Model model){
        VehicleMake vehicleMake = vehicleMakeService.findById(id);
        model.addAttribute("vehicleMake", vehicleMake);
        return "/fleet/VehicleMake/vehicleMakeEdit";
    }

    @PostMapping(value = "/vehicleMake/update/{id}")
    public String updateVehicleMakeFromVehicleMakeEditPage(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicleMake() {
        return new HiddenHttpMethodFilter();
    }

}
