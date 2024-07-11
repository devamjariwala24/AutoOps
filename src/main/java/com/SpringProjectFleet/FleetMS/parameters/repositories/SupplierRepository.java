package com.SpringProjectFleet.FleetMS.parameters.repositories;

import com.SpringProjectFleet.FleetMS.parameters.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
