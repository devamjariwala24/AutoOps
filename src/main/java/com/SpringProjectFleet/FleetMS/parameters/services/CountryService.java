package com.SpringProjectFleet.FleetMS.parameters.services;

import com.SpringProjectFleet.FleetMS.parameters.models.Country;
import com.SpringProjectFleet.FleetMS.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    // here, we have to autowire the repository with the service to fetch the data coming from the repository into the
    // service.

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getALl(){
        return countryRepository.findAll();
    }
}
