package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Traffic_ticket;

@Repository
public interface TicketRepository extends JpaRepository<Traffic_ticket, Long>{

}
