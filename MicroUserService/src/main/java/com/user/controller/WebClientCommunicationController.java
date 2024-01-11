package com.user.controller;


import java.net.Authenticator.RequestorType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator.RequestType;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebClientCommunicationController {
	
	@Autowired
    private WebClient.Builder webClientBuilder;
	
	@Autowired
	UserService userService;
	
	
	/*
	 * @RequestMapping("/getUserByWebClient/{id}") public ResponseEntity<User>
	 * getUserById(@PathVariable int id){ User u = userService.getUserById(id);
	 * Rating[] ratingList = webClient.get()
	 * .uri("http://RATINGSERVICE/RatingService/rating/getAllRatingByUserId/"+u.
	 * getId()) .accept(MediaType.APPLICATION_JSON) .retrieve().
	 * //bodyToFlux(Rating.class).collect(Collectors.toList()).share().block();
	 * bodyToFlux(Rating[].class); System.out.println("ratingList...."+ ratingList);
	 * 
	 * 
	 * // List<Rating> ratingList = ratingFlux.collectList().block();
	 * 
	 * u.setRating(ratingList);
	 * 
	 * return ResponseEntity.ok(u);
	 * 
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/getUserByWebClient/{userID}", method = RequestMethod.GET)
	ResponseEntity<User> getUserByID(@PathVariable Integer userID){
		User user = userService.getUserById(userID);
		System.out.println("user...."+user.getId());
		
		Rating[] ratingsMono = webClientBuilder
								.build()
								.get()
								.uri("http://RATINGSERVICE/RatingService/rating/getAllRatingByUserId/" + userID)
								.retrieve()
								.bodyToMono(Rating[].class)
								.block();
		System.out.println("....."+ratingsMono);
		List<Rating> ratings = Arrays.asList(ratingsMono);
		user.setRating(ratings);
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/getUser/{id}")
	Mono<User> getUser(@PathVariable Integer id){
		System.out.println("getUser..."+id);
		return this.webClientBuilder.build().get().uri("http://UserService/user/getUser/"+id)
				.retrieve().bodyToMono(User.class);
	}
	
	
	

}
