package com.SpringProjectFleet.FleetMS.helpdesk.repositories;

import com.SpringProjectFleet.FleetMS.helpdesk.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}