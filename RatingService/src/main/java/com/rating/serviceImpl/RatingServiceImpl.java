package com.rating.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Hotel;
import com.rating.entity.Rating;
import com.rating.repository.RatingRepository;
import com.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired 
	RatingRepository ratingRepository;

	@Override
	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUserId(int userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(int hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

	@Override
	public Hotel getHotelByRatingId(String ratingId) {
		return ratingRepository.findHotelByRatingId(ratingId);
	}

}
