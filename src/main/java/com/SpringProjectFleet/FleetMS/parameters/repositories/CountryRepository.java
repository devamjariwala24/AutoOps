package com.SpringProjectFleet.FleetMS.parameters.repositories;

import com.SpringProjectFleet.FleetMS.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "select c from Country c where concat(c.capital, c.code, c.continent, c.description, c.nationality) LIKE %?1% ")
    List<Country> findByKeyword(String keyword);

}

