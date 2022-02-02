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

	RestaurantRepository restauranReposiroty;

	public static final ModelMapper modelMapper = new ModelMapper();

	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	public List<RestaurantRest> GetRestaurants() throws BookingException {
		final List<Restaurant> RestaurantsEntity = restauranReposiroty.findAll();

		return RestaurantsEntity.stream().map(Service -> modelMapper.map(Service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
		return restauranReposiroty.findById(restaurantId)
				.orElseThrow(() -> new NotFoundException("Snot-404-1", "RESTAURANT NOT FOUND"));
	}

	@Override
	public List<RestaurantRest> getRestaurants() throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}
}
