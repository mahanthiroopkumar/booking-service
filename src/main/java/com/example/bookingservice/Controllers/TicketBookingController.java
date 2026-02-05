package com.example.bookingservice.Controllers;

import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookingservice.Entities.BookTicketDTO;
import com.example.bookingservice.Services.BookTicketService;

import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/Booking")
public class TicketBookingController {
	
	@Autowired
	private BookTicketService bookTicketService;

	@PostMapping("/bookTicket")
	public ResponseEntity<Map<String,Object>> bookTicket(@RequestBody BookTicketDTO bookTicketDTO){
		bookTicketService.bookTicket(bookTicketDTO);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Map.of("message","Ticket Booked Successfully"));
	}
	
	
	@GetMapping("price/{showid}")
	public ResponseEntity<Map<String,Object>> getPrice(@PathVariable("showid") int id){
		Map<String,Object> getprice = bookTicketService.getprice(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Map.of("price",getprice.get("price")));
	}

	// Demo for Testing:-
	
	@GetMapping("getMessage")
	public ResponseEntity<Map<String,Object>> getMessage(){
		Map<String,Object> message = bookTicketService.getMessage();
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Map.of("message",message.get("message")));
	}
	
	@GetMapping("/seatAvailability/{showid}/{seatnumber}")
	public ResponseEntity<Map<String,Object>> seatAvailability(@PathVariable("showid")int showid,
			@PathVariable("seatnumber") int seatnumber){
		boolean checkAvailability = bookTicketService.checkAvailability(showid, seatnumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Map.of("avail",checkAvailability));
	}
	
	@GetMapping("/findByUsername/{username}")
	public ResponseEntity<Map<String,Object>> findByUsername(@PathVariable("username") String name){
		Map<Integer,List<Object>> byUser = bookTicketService.findByUser(name);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Map.of("Tickets",byUser));
	}
}
