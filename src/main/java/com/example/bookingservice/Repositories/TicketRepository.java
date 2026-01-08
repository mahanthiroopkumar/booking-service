package com.example.bookingservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookingservice.Entities.Ticket;
import java.util.List;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
		List<Ticket> findByUsername(String username);
}
