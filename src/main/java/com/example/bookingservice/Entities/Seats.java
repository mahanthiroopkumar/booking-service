package com.example.bookingservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Seats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatsid;
	
	@ManyToOne
	@JoinColumn(name = "ticketid")
	@JsonIgnore
	private Ticket ticket;
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	private int showid;
	private int seatnumber;

	public int getSeatsid() {
		return seatsid;
	}
	public void setSeatsid(int seatsid) {
		this.seatsid = seatsid;
	}
	
	public int getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}
	
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
}
