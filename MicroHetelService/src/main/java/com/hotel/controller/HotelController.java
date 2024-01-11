package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/saveHotel")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel data = hotelService.saveHotel(hotel);
		return new ResponseEntity<Hotel>(data,HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/getAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotel = hotelService.getAllHotels();
		return ResponseEntity.ok(hotel);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/getHotelById/{id}")
	public ResponseEntity<Hotel> getAllHotel(@PathVariable int id){
		Hotel hotel = hotelService.getHotelById(id);
		return ResponseEntity.ok(hotel);
	}

}
