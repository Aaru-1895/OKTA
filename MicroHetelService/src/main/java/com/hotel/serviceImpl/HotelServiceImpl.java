package com.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;


@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(int id) {
		
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found For This Id"));
	}

}
