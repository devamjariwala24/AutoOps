package com.SpringProjectFleet.FleetMS.fleet.services;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleHire;
import com.SpringProjectFleet.FleetMS.fleet.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    //Get All VehicleHires
    public List<VehicleHire> findAll(){
        return vehicleHireRepository.findAll();
    }

    //Get VehicleHire By Id
    public VehicleHire findById(int id) {
        return vehicleHireRepository.findById(id).orElse(null);
    }

    //Delete VehicleHire
    public void delete(int id) {
        vehicleHireRepository.deleteById(id);
    }

    //Update VehicleHire
    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

}