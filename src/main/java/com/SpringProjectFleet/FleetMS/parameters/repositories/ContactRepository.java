package com.SpringProjectFleet.FleetMS.parameters.repositories;


import com.SpringProjectFleet.FleetMS.parameters.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
