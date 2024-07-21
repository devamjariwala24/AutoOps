package com.SpringProjectFleet.FleetMS.fleet.services;


import com.SpringProjectFleet.FleetMS.fleet.models.VehicleType;
import com.SpringProjectFleet.FleetMS.fleet.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    //Get All VehicleTypes
    public List<VehicleType> findAll(){
        return vehicleTypeRepository.findAll();
    }

    //Get VehicleType By Id
    public VehicleType findById(Integer id) {
        return vehicleTypeRepository.findById(id).orElse(null);
    }

    //Delete VehicleType
    public void delete(int id) {
        vehicleTypeRepository.deleteById(id);
    }

    //Update VehicleType
    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

}