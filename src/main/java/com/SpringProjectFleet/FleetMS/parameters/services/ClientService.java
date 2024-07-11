package com.SpringProjectFleet.FleetMS.parameters.services;
import com.SpringProjectFleet.FleetMS.parameters.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import com.SpringProjectFleet.FleetMS.parameters.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }


}
