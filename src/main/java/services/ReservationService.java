package services;


import Exceptions.BookingException;
import jsons.CreateReservationRest;
import jsons.RestaurantRest;


public interface ReservationService {

	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

	String createReservation(CreateReservationRest CreateReservationRest) throws BookingException;
}
