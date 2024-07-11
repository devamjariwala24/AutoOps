package com.SpringProjectFleet.FleetMS.parameters.repositories;

import com.SpringProjectFleet.FleetMS.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    @Query("SELECT s FROM State s WHERE s.country.id = :countryId")
    List<State> findByCountryId(@Param("countryId") Integer countryId);

}