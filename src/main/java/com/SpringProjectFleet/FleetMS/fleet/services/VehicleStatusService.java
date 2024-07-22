package com.SpringProjectFleet.FleetMS.fleet.services;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleStatus;
import com.SpringProjectFleet.FleetMS.fleet.models.VehicleType;
import com.SpringProjectFleet.FleetMS.fleet.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    //Get All VehicleStatus
    public List<VehicleStatus> findAll(){
        return vehicleStatusRepository.findAll();
    }

    //Get VehicleStatus By Id
    public VehicleStatus findById(Integer id) {
        return vehicleStatusRepository.findById(id).orElse(null);
    }

    //Delete VehicleStatus
    public void delete(int id) {
        vehicleStatusRepository.deleteById(id);
    }

    //Update VehicleStatus
    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

}