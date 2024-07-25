package com.SpringProjectFleet.FleetMS.helpdesk.services;

import com.SpringProjectFleet.FleetMS.helpdesk.models.Ticket;
import com.SpringProjectFleet.FleetMS.helpdesk.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    //Get Ticket By Id
    public Ticket findById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }


    //Delete Ticket
    public void delete(int id) {
        ticketRepository.deleteById(id);
    }

    //Update Ticket
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
