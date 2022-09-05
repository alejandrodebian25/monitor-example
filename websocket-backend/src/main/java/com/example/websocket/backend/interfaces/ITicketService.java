package com.example.websocket.backend.interfaces;
import java.util.List;

import com.example.websocket.backend.entity.Ticket;


public interface ITicketService {
    public List<Ticket> findAll();

    public Ticket save(Ticket ticket);
}
