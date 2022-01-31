package services;

import Exceptions.BookingException;

public interface CancelReservationService {
	public String deleteReservation(String locator) throws BookingException;
}
