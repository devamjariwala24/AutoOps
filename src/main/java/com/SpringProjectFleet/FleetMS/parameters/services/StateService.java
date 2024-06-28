package com.SpringProjectFleet.FleetMS.parameters.services;


import com.SpringProjectFleet.FleetMS.parameters.models.State;
import com.SpringProjectFleet.FleetMS.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    //Get All States
    public List<State> findAll(){
        return stateRepository.findAll();
    }

    //Get State By Id
    public State findById(int id) {
        return stateRepository.findById(id).orElse(null);
    }

    //Delete State
    public void delete(int id) {
        stateRepository.deleteById(id);
    }

    //Update State
    public void save( State state) {
        stateRepository.save(state);
    }
}