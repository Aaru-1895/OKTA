package com.rating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("rating_service")
public class Rating {
	
	@Id
	private String ratingId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
	
	private Hotel hotel;
	

}
