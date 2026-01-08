package com.example.bookingservice.OpenFeign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("MOVIESERVICE")
public interface ConnectingInterface {
	
	@GetMapping("Movie/fromMovieService")
	public ResponseEntity<Map<String,Object>> fromMovieService();
	
	@GetMapping("Movie/allMovies")
	public ResponseEntity<Map<String,Object>> findAll();
	
	@GetMapping("/Showdetails/price/{showid}")
	public ResponseEntity<Map<String,Object>> getPrice(@PathVariable("showid") int showid);
	
	@GetMapping("/Showdetails/findById/{id}")
	public ResponseEntity<Map<String,Object>> findById(@PathVariable("id") int id);
}

