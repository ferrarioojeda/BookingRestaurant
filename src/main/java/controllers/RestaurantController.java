package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Exceptions.BookingException;
import jsons.RestaurantRest;
import response.BookingResponse;
import services.RestaurantService;

@RestController
@RequestMapping(path = "/")

public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurant" + "/{" + "restaurantId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
		System.out.println("hola mundo");
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "Ok",
				restaurantService.getRestaurantById(restaurantId));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<List<RestaurantRest>> getRestaurants()throws BookingException {
		System.out.println("hola mundo");
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", restaurantService.GetRestaurants());
	}

}
