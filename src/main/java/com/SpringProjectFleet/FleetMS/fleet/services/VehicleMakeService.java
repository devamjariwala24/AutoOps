package com.SpringProjectFleet.FleetMS.fleet.services;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleMake;
import com.SpringProjectFleet.FleetMS.fleet.models.VehicleType;
import com.SpringProjectFleet.FleetMS.fleet.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    //Get All VehicleMakes
    public List<VehicleMake> findAll(){
        return vehicleMakeRepository.findAll();
    }

    //Get VehicleMake By Id
    public VehicleMake findById(Integer id) {
        return vehicleMakeRepository.findById(id).orElse(null);
    }

    //Delete VehicleMake
    public void delete(int id) {
        vehicleMakeRepository.deleteById(id);
    }

    //Update VehicleMake
    public void save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

}