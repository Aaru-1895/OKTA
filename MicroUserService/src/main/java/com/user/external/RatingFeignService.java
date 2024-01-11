package com.user.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.user.entity.Rating;

@FeignClient(name = "RATINGSERVICE")
public interface RatingFeignService {
	
	@RequestMapping(value = "/RatingService/rating/getAllRatingByUserId/{userId}",method = RequestMethod.GET)
	public Rating[] getRatingByUserid(@PathVariable  int userId);

}
	