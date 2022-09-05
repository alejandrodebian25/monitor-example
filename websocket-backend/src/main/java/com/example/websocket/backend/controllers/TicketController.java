package com.example.websocket.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.websocket.backend.entity.Ticket;
import com.example.websocket.backend.interfaces.ITicketService;

@RestController
@RequestMapping(value = "/api")
public class TicketController {

    private SimpMessagingTemplate template;

    @Autowired
    public TicketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Autowired
    ITicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @PostMapping("/tickets")
    public Ticket store(@RequestBody Ticket ticket) {
        Ticket ticketCreated = ticketService.save(ticket);
        this.template.convertAndSend("/ticketero/monitor", ticketCreated);
        return ticketCreated;
    }
}
