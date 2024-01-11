package com.rating.service;

import java.util.List;

import com.rating.entity.Hotel;
import com.rating.entity.Rating;

public interface RatingService {
	
	public Rating saveRating(Rating ratinng);
	
	public  List<Rating> getAllRating();
	
	public  List<Rating> getAllRatingByUserId(int userId);
	
	public  List<Rating> getAllRatingByHotelId(int hotelId);
	
	public Hotel getHotelByRatingId(String ratingId);

}
