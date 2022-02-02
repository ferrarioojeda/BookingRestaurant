package com.boot.bookingrestaurantapi.services;


import com.boot.bookingrestaurantapi.Exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;


public interface ReservationService {

	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

	String createReservation(CreateReservationRest CreateReservationRest) throws BookingException;
}
