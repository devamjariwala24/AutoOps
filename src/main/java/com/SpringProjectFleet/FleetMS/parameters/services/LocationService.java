package com.SpringProjectFleet.FleetMS.parameters.services;


import com.SpringProjectFleet.FleetMS.parameters.models.Location;
import com.SpringProjectFleet.FleetMS.parameters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return (List<Location>) locationRepository.findAll();
    }

    public Location findById(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    public void save(Location location) {
        locationRepository.save(location);
    }

    public void deleteById(Integer id) {
        locationRepository.deleteById(id);
    }

    public List<Location> findByDescriptionContaining(String description) {
        return null;
    }
}