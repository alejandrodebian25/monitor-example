package com.example.websocket.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.websocket.backend.entity.Ticket;

public interface ITicketDao extends JpaRepository<Ticket, Long> {

}
