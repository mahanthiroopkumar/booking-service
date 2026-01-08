package com.example.bookingservice.Entities;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookTicketDTO {
	
	private int showid;
	private List<Integer> seatNumbers;
	
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
	public List<Integer> getSeatNumbers() {
		return seatNumbers;
	}
	public void setSeatNumbers(List<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
}
