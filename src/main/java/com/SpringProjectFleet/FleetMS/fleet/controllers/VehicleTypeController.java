package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleType;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleTypes")
    public String findAll(Model model){
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        return "/fleet/VehicleTypes/vehicleTypes";
    }

    @RequestMapping("/vehicleType{id}")
    @ResponseBody
    public Optional<VehicleType> findById(@PathVariable Integer id){
        return vehicleTypeService.findById(id);
    }

    //Add VehicleType
    @PostMapping(value="/addNewVehicleTypeRecord")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value="fleet/vehicleType/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }
}
