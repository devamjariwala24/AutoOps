package com.SpringProjectFleet.FleetMS.parameters.repositories;

import com.SpringProjectFleet.FleetMS.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

        @Query("SELECT c FROM Country c LEFT JOIN FETCH c.states WHERE c.id = :id")
        Optional<Country> findByIdWithStates(@Param("id") Integer id);
    }

