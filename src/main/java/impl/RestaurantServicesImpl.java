package impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.BookingException;
import dtos.NotFoundException;
import entities.Restaurant;
import jsons.RestaurantRest;
import repositories.RestaurantRepository;
import services.RestaurantService;

@Service
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
}
