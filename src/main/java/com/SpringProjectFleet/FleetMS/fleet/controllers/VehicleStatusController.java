package com.SpringProjectFleet.FleetMS.fleet.controllers;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleStatus;
import com.SpringProjectFleet.FleetMS.fleet.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatus")
    public String findAll(Model model) {
        model.addAttribute("vehicleStatus", vehicleStatusService.findAll());
        return "/fleet/VehicleStatus/vehicleStatus";
    }

    @GetMapping("/vehicleStatusDetails{id}")
    public String detailVehicleStatus(@PathVariable Integer id, Model model) {
        VehicleStatus vehicleStatus = vehicleStatusService.findById(id);
        model.addAttribute("vehicleStatus", vehicleStatus);
        return "/fleet/VehicleStatus/vehicleStatusDetails";
    }

    @GetMapping("/addNewVehicleStatusRecord")
    public String vehicleStatusAddFromVehicleStatusPage() {
        return "/fleet/VehicleStatus/vehicleStatusAdd";
    }

    @PostMapping(value = "/addNewVehicleStatus")
    public String addNewVehicleStatusRecordFromVehicleStatusAddPage(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @DeleteMapping(value = "/vehicleStatus/delete/{id}")
    public String deleteFromVehicleStatusPage(@PathVariable Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatus";
    }

    @GetMapping("/vehicleStatusEdit{id}")
    public String editVehicleStatusFromVehiclePage(@PathVariable Integer id, Model model) {
        VehicleStatus vehicleStatus = vehicleStatusService.findById(id);
        model.addAttribute("vehicleStatus", vehicleStatus);
        return "/fleet/VehicleStatus/vehicleStatusEdit";
    }

    @PostMapping(value = "/vehicleStatus/update/{id}")
    public String updateVehicleStatusFromVehicleStatusEditPage(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForVehicleStatus() {
        return new HiddenHttpMethodFilter();
    }

}
