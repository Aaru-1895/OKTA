package com.user.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelFeignService {
	
	@RequestMapping(value = "/HotelService/hotel/getHotelById/{hotelId}",method = RequestMethod.GET)
	public Hotel HotelById(@PathVariable int hotelId);

}
