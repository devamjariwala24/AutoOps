package com.SpringProjectFleet.FleetMS.helpdesk.services;

import com.SpringProjectFleet.FleetMS.helpdesk.models.Ticket;

import com.SpringProjectFleet.FleetMS.helpdesk.models.TicketStatus;
import com.SpringProjectFleet.FleetMS.helpdesk.repositories.TicketStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketStatusService {

    @Autowired
    private TicketStatusRepository ticketStatusRepository;

    public List<TicketStatus> findAll(){
        return ticketStatusRepository.findAll();
    }

    //Get Ticket By Id
    public TicketStatus findById(int id) {
        return ticketStatusRepository.findById(id).orElse(null);
    }


    //Delete Ticket
    public void delete(int id) {
        ticketStatusRepository.deleteById(id);
    }

    //Update Ticket
    public void save(TicketStatus ticketStatus) {
        ticketStatusRepository.save(ticketStatus);
    }
}
