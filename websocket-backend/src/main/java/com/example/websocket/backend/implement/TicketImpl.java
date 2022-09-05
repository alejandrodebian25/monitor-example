package com.example.websocket.backend.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websocket.backend.dao.ITicketDao;
import com.example.websocket.backend.entity.Ticket;
import com.example.websocket.backend.interfaces.ITicketService;

@Service
public class TicketImpl implements ITicketService {
    
    @Autowired
    ITicketDao ticketDao;

    @Transactional
    @Override
    public Ticket save(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }
}
