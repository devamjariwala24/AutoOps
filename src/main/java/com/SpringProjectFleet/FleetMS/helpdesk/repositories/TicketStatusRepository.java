package com.SpringProjectFleet.FleetMS.helpdesk.repositories;

import com.SpringProjectFleet.FleetMS.helpdesk.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {

}