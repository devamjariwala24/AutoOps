package com.SpringProjectFleet.FleetMS.fleet.repositories;

import com.SpringProjectFleet.FleetMS.fleet.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}