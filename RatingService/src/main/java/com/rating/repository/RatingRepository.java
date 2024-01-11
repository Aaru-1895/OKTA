package com.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rating.entity.Hotel;
import com.rating.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String>{
	
	public List<Rating> findByUserId(int userId);
	
	public List<Rating> findByHotelId(int hotelId);
	
	public Hotel findHotelByRatingId(String ratingId);

}
