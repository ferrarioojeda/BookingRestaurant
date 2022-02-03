package com.boot.bookingrestaurantapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.Exceptions.BookingException;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.response.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/booking-restaurant")
@Api(value = "/booking-restaurant", produces = "application/json")
public class RestaurantController {

	@Autowired
	@Qualifier("restaurantServiceImpl")
	RestaurantService restaurantService;

	@ApiOperation(value = "Retorna el restaurat por id")

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurant" + "/{" + "restaurantId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public Restaurant getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
		return restaurantService.getRestaurantById(restaurantId);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurant> getRestaurants() throws BookingException {
		
		return restaurantService.getRestaurants();
	}

}
