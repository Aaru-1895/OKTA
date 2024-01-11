package com.rating.controller;

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

import com.rating.entity.Hotel;
import com.rating.entity.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/saveRating")
	public ResponseEntity<Rating> SaveRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}
	
	
	@GetMapping("/getAllRating")
	public ResponseEntity<List<Rating>> getAllRating(){
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/getAllRatingByUserId/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable int userId){
		return ResponseEntity.ok(ratingService.getAllRatingByUserId(userId));
	}
	
	@GetMapping("/getAllRatingByHotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRating(@PathVariable int hotelId ){
		return ResponseEntity.ok(ratingService.getAllRatingByHotelId(hotelId));
	}
	
	
	@GetMapping("/getHotel/{ratingId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String ratingId ){
		System.out.println("ratingId..."+ratingId);
		return ResponseEntity.ok(ratingService.getHotelByRatingId("ObjectId('64160a1a17b28344413b96be')"));
	}

}