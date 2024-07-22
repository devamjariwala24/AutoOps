package com.SpringProjectFleet.FleetMS.fleet.services;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleMaintenance;
import com.SpringProjectFleet.FleetMS.fleet.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMaintenanceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    //Get All VehicleMaintenances
    public List<VehicleMaintenance> findAll(){
        return vehicleMaintenanceRepository.findAll();
    }

    //Get VehicleMaintenance By Id
    public VehicleMaintenance findById(int id) {
        return vehicleMaintenanceRepository.findById(id).orElse(null);
    }

    //Delete VehicleMaintenance
    public void delete(int id) {
        vehicleMaintenanceRepository.deleteById(id);
    }

    //Update VehicleMaintenance
    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }
}