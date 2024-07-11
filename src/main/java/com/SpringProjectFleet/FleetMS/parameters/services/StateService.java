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

        return states.stream()
                .map(state -> {
                    State simplifiedState = new State();
                    simplifiedState.setId(state.getId());
                    simplifiedState.setName(state.getName());
                    simplifiedState.setCapital(state.getCapital());
                    simplifiedState.setCode(state.getCode());
                    simplifiedState.setDetails(state.getDetails());
                    Country simplifiedCountry = new Country();
                    simplifiedCountry.setId(state.getCountry().getId());
                    simplifiedState.setCountry(simplifiedCountry);

                    return simplifiedState;
                })
                .collect(Collectors.toList());
    }

    public void save( State state) {
        stateRepository.save(state);
    }
}