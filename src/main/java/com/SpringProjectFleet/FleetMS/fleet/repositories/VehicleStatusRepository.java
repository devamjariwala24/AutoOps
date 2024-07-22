package com.SpringProjectFleet.FleetMS.fleet.repositories;

import com.SpringProjectFleet.FleetMS.fleet.models.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {

}