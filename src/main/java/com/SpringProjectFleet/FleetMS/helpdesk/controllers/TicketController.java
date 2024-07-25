package com.SpringProjectFleet.FleetMS.helpdesk.controllers;

import com.SpringProjectFleet.FleetMS.helpdesk.models.Ticket;
import com.SpringProjectFleet.FleetMS.helpdesk.services.TicketService;
import com.SpringProjectFleet.FleetMS.helpdesk.services.TicketStatusService;
import com.SpringProjectFleet.FleetMS.hr.services.EmployeeService;
import com.SpringProjectFleet.FleetMS.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketStatusService ticketStatusService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/tickets")
    public String findAll(Model model) {
        model.addAttribute("tickets", ticketService.findAll());
        model.addAttribute("clients", clientService.findAll());
//        model.addAttribute("ticketStatuses", ticketStatusService.findAll());
//        model.addAttribute("employeeTicket", employeeService.findAll());
        return "/helpdesk/Tickets/tickets";
    }

    @GetMapping("/ticketDetails{id}")
    public String detailTicket(@PathVariable Integer id, Model model) {
        Ticket ticket = ticketService.findById(id);
        model.addAttribute("employeeTicket", employeeService.findAll());
        model.addAttribute("ticket", ticket);
        return "/helpdesk/Tickets/ticketDetails";
    }

    @GetMapping("/addNewTicketRecord")
    public String ticketAddFromTicketPage(Model model) {
        model.addAttribute("employeeTicket", employeeService.findAll());
        model.addAttribute("ticketStatusAdd", ticketStatusService.findAll());
        return "/helpdesk/Tickets/ticketAdd";
    }

    @PostMapping(value = "/addNewTicket")
    public String addNewTicketRecordFromTicketAddPage(Ticket ticket) {
        ticketService.save(ticket);
        return "redirect:/tickets";
    }

    @DeleteMapping(value = "/ticket/delete/{id}")
    public String deleteFromTicketPage(@PathVariable Integer id) {
        ticketService.delete(id);
        return "redirect:/tickets";
    }


    @GetMapping("/ticketEdit{id}")
    public String editTicketFromTicketPage(@PathVariable Integer id, Model model) {
        Ticket ticket = ticketService.findById(id);
        model.addAttribute("ticket", ticket);
        model.addAttribute("ticketStatuses", ticketStatusService.findAll()); // Add this line
        model.addAttribute("employeeTicket", employeeService.findAll());
        return "/helpdesk/Tickets/ticketEdit";
    }

    @PostMapping(value = "/ticket/update/{id}")
    public String updateTicketFromTicketEditPage(Ticket ticket, Model model) {
        ticketService.save(ticket);
        return "redirect:/tickets";
    }


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilterForTicket() {
        return new HiddenHttpMethodFilter();
    }


}
