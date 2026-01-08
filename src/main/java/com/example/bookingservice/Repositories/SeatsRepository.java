package com.example.bookingservice.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookingservice.Entities.Seats;


@Repository
public interface SeatsRepository extends JpaRepository<Seats, Integer> {
		Optional<Seats> findByTicket_ShowidAndSeatnumber(int ticket_Showid, int seatnumber);
}
