package com.SpringProjectFleet.FleetMS.fleet.services;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleModel;
import com.SpringProjectFleet.FleetMS.fleet.models.VehicleType;
import com.SpringProjectFleet.FleetMS.fleet.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    //Get All VehicleModels
    public List<VehicleModel> findAll(){
        return vehicleModelRepository.findAll();
    }

    public VehicleModel findById(Integer id) {
        return vehicleModelRepository.findById(id).orElse(null);
    }

    //Delete VehicleModel
    public void delete(int id) {
        vehicleModelRepository.deleteById(id);
    }

    //Update VehicleModel
    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

}