package com.SpringProjectFleet.FleetMS.parameters.services;


import com.SpringProjectFleet.FleetMS.parameters.models.Country;
import com.SpringProjectFleet.FleetMS.parameters.models.State;
import com.SpringProjectFleet.FleetMS.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<State> findByCountryId(Integer countryId) {
        List<State> states = stateRepository.findByCountryId(countryId);
        System.out.println("Found " + states.size() + " states for country ID: " + countryId);
        for (State state : states) {
            System.out.println("State: " + state.getId() + " - " + state.getName());
        }
        return states.stream()
                .map(this::simplifyState)
                .collect(Collectors.toList());
    }

    private State simplifyState(State state) {
        State simplifiedState = new State();
        simplifiedState.setId(state.getId());
        simplifiedState.setName(state.getName());
        simplifiedState.setCapital(state.getCapital());
        simplifiedState.setCode(state.getCode());
        simplifiedState.setDetails(state.getDetails());
        // Set a simplified country object to avoid circular references
        Country simplifiedCountry = new Country();
        simplifiedCountry.setId(state.getCountry().getId());
        simplifiedState.setCountry(simplifiedCountry);
        return simplifiedState;
    }
    public void save( State state) {
        stateRepository.save(state);
    }
}