package com.SpringProjectFleet.FleetMS.parameters.repositories;

import com.SpringProjectFleet.FleetMS.parameters.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
