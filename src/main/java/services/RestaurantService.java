package services;

import java.util.List;

import Exceptions.BookingException;
import jsons.RestaurantRest;

public interface RestaurantService {
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
	
	public List<RestaurantRest> GetRestaurants() throws BookingException;
}
