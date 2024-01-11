package com.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.external.HotelFeignService;
import com.user.service.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

import com.user.external.RatingFeignService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelFeignService hotelService;
	
	@Autowired
	RatingFeignService ratingService;
	
	
	@PostMapping("/save")
	public ResponseEntity<User> saveuserData(@RequestBody User user){
		User u = userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
		
		
	}
	int count=1;
	
	/*****************************************************Using Rest Templet*************************************************************/
	
	
	@GetMapping("/getUser/{id}")
	//@CircuitBreaker(name="ratingHotelBreaker" , fallbackMethod = "ratingHotelFallBack")
	//@Retry(name="ratingHotelBreaker", fallbackMethod="ratingHotelFallBack")
	@RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getUserByid(@PathVariable int id){
		count++;
		User u = userService.getUserById(id);
		System.out.println("u..."+u);
		System.out.println("count  for retry ..."+count);
		
		/******************* For  GET mapping ****************************/
		
		//Rating[] retings=restTemplate.getForObject("http://RATINGSERVICE/RatingService/rating/getAllRatingByUserId/"+u.getId(), Rating[].class);
		
		/******************* For  Post mapping ****************************/
		
		Rating[] retings=restTemplate.getForObject("http://RATINGSERVICE/RatingService/rating/getAllRatingByUserId/"+u.getId(), Rating[].class);
		
		List<Rating> RatingList = Arrays.stream(retings).toList();
		
		List<Rating> r=RatingList.stream().map(rating -> {
			
			ResponseEntity<Hotel> hotelData = restTemplate.getForEntity("http://HOTELSERVICE/HotelService/hotel/getHotelById/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelData.getBody();
			
			rating.setHotel(hotel);
		
			return rating;
			
		}).collect(Collectors.toList());
		u.setRating(RatingList);
		
		return ResponseEntity.ok(u);
	}
	
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		System.out.println("user calling");
		List<User> u = userService.getAllUser();
		System.out.println(u);
		
		return ResponseEntity.ok(u);
	}
	
	/*****************************************************Using feign client*************************************************************/
	
	@GetMapping("/getFeignUser/{id}")
	public ResponseEntity<User> getFeignUser(@PathVariable int id){
		User u = userService.getUserById(id);
		
		
		Rating[] retings=ratingService.getRatingByUserid(u.getId());
		
		List<Rating> RatingList = Arrays.stream(retings).toList();
		
		List<Rating> r=RatingList.stream().map(rating -> {
			
			Hotel hotel=hotelService.HotelById(rating.getHotelId());
			
			rating.setHotel(hotel);
		
			return rating;
			
		}).collect(Collectors.toList());
		u.setRating(RatingList);
		
		return ResponseEntity.ok(u);
	}
	
	
	/******************************Fall Back Method****************************************/
	
	public ResponseEntity<User> ratingHotelFallBack(int id,Exception ex){
		System.out.println("Error info."+ex.getMessage());
		User u = userService.getUserById(id);
		/*
		 * User user=User.builder() .email("default@gmail.com") .name("default")
		 * .mobile("123") .build();
		 */
		
		return ResponseEntity.ok(u);
		
		
	}
  
}
