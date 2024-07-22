package com.SpringProjectFleet.FleetMS.fleet.repositories;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}