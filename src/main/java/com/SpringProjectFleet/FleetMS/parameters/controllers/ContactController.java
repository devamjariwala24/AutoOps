package com.SpringProjectFleet.FleetMS.parameters.controllers;


import com.SpringProjectFleet.FleetMS.parameters.models.Contact;
import com.SpringProjectFleet.FleetMS.parameters.models.Country;
import com.SpringProjectFleet.FleetMS.parameters.models.State;
import com.SpringProjectFleet.FleetMS.parameters.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.List;


@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getAll(Model model){
        List<Contact> contacts =   contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "/parameters/Contacts/contacts";
    }

    @GetMapping("/contactAdd")
    public String addContact(){
        return "parameters/Contacts/contactAdd";
    }


    @PostMapping("/parameters/contactsAdd")
    public String saveContactFromContactAddPage(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contactDetails{id}")
    public String detailsState(@PathVariable Integer id, Model model){
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "/parameters/Contacts/contactDetails";
    }

    @GetMapping("/contactEdit{id}")
    public String editContact(@PathVariable Integer id, Model model){
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "/parameters/Contacts/contactEdit";
    }

    @PostMapping(value = "/contact/update/{id}")
    public String updateContactFromContactEditPage(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @DeleteMapping(value="/contacts/delete/{id}")
    public String delete(@PathVariable Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }



    @Bean
    public HiddenHttpMethodFilter hiddenContactHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


}
