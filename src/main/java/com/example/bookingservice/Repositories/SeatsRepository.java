package com.example.bookingservice.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookingservice.Entities.Seats;
import java.util.List;



@Repository
public interface SeatsRepository extends JpaRepository<Seats, Integer> {
		Optional<Seats> findByShowidAndSeatnumber(int showid, int seatnumber);
}
