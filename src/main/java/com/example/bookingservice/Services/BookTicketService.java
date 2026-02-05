package com.example.bookingservice.Services;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookingservice.Entities.BookTicketDTO;
import com.example.bookingservice.Entities.Seats;
import com.example.bookingservice.Entities.Ticket;
import com.example.bookingservice.ExceptionHandling.AlreadyExistsException;
import com.example.bookingservice.OpenFeign.ConnectingInterface;
import com.example.bookingservice.Repositories.SeatsRepository;
import com.example.bookingservice.Repositories.TicketRepository;

@Service
public class BookTicketService {
	
	@Autowired
	private ConnectingInterface connectingInterface;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private SeatsRepository seatsRepository;

	@Transactional
	public void bookTicket(BookTicketDTO bookTicketDTO) {
//      we need to check wheater seats are already reserved or not
//		for(int seatnumber:bookTicketDTO.getSeatNumbers()) {
//			if(checkAvailability(bookTicketDTO.getShowid(),seatnumber)) {
//				throw new AlreadyExistsException("the seat you selected is already reserved.");
//			}
//		}
		
		Ticket ticket=new Ticket();
		ticket.setShowid(bookTicketDTO.getShowid());
		ticket.setUsername("roopkumar");
		Integer price = (Integer) getprice(bookTicketDTO.getShowid()).get("price");
		int seatsCount=bookTicketDTO.getSeatNumbers().size();
		ticket.setTotalprice(seatsCount*price);
		
		ticketRepository.save(ticket);
		try {
			for(int seatnumber:bookTicketDTO.getSeatNumbers()) {
				Seats seats=new Seats(); 
				seats.setSeatnumber(seatnumber);
				seats.setTicket(ticket);
				seats.setShowid(bookTicketDTO.getShowid());
				seatsRepository.save(seats);
			}
		}catch(Exception e){
			throw new AlreadyExistsException("the seat you selected is already reserved.");
		}
		
		
	}
	
	public  @Nullable Map<String, Object> getprice(int id) {
		return connectingInterface.getPrice(id).getBody();
	}
	
	public Map<String, Object> getMessage() {
		return connectingInterface.fromMovieService().getBody();
	}
	
	public boolean checkAvailability(int showid, int seatnumber) {
		Optional<Seats> avail = seatsRepository.findByShowidAndSeatnumber(showid, seatnumber);
		if(avail.isEmpty()) return false;
		return true;
	}
	
	public Map<Integer, List<Object>> findByUser(String name) {
		List<Ticket> byUsername = ticketRepository.findByUsername(name);
		Map<Integer,List<Object>> result=new HashMap<>();
		for(Ticket ticket: byUsername) {
			List<Object> data=new ArrayList<>();
			Object show = connectingInterface.findById(ticket.getShowid()).getBody().get("show");
			data.add(ticket);
			data.add(show);
			result.put(ticket.getTicketid(),data);
		}
		return result;
	}
}
