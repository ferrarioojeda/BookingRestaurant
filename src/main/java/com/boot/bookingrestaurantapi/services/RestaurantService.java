package com.boot.bookingrestaurantapi.services;

import java.util.List;

import com.boot.bookingrestaurantapi.Exceptions.BookingException;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;

public interface RestaurantService {
	Restaurant getRestaurantById(Long restaurantId) throws BookingException;
	
	public List<Restaurant> getRestaurants() throws BookingException;
}
