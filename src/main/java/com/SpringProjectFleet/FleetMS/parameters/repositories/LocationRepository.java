package com.SpringProjectFleet.FleetMS.parameters.repositories;

import com.SpringProjectFleet.FleetMS.parameters.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}