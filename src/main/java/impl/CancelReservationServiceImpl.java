package impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Exceptions.BookingException;
import dtos.InternalServerException;
import dtos.NotFoundException;
import repositories.ReservationRepository;
import services.CancelReservationService;

public class CancelReservationServiceImpl implements CancelReservationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);

	@Autowired
	private ReservationRepository reservationRepository;

	public String deleteReservation(String locator) throws BookingException {
		reservationRepository.findByLocation(locator)
				.orElseThrow(() -> new NotFoundException("LOCATOR_NOYfOUND", "LOCATOR_NOT_FOUND"));
		try {
			reservationRepository.deleteByLocation(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "LOCATOR_DELETE";
	}

}
