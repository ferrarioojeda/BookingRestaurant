package com.boot.bookingrestaurantapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.Exceptions.BookingException;
import com.boot.bookingrestaurantapi.dtos.NotFoundException;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.services.RestaurantService;

@Service("restaurantServiceImpl")
public class RestaurantServicesImpl implements RestaurantService {

	@Autowired

	RestaurantRepository restauranRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	public Restaurant getRestaurantById(Long restaurantId) throws BookingException {
		return restauranRepository.findById(restaurantId).get();
	}

	

	@Override
	public List<Restaurant> getRestaurants() throws BookingException {
		System.out.println("hola mundo");
		return restauranRepository.findAll();
		
		//return RestaurantsEntity.stream().map(Service -> modelMapper.map(Service, RestaurantRest.class))
			//	.collect(Collectors.toList());
		
	}
}
