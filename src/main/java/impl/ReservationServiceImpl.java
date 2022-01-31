package impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Exceptions.BookingException;
import dtos.InternalServerException;
import dtos.NotFoundException;
import entities.Reservation;
import entities.Restaurant;
import entities.Turn;
import jsons.CreateReservationRest;
import jsons.RestaurantRest;
import repositories.ReservationRepository;
import repositories.RestaurantRepository;
import repositories.TurnRepository;
import services.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private RestaurantRepository restauranteRepository;

	@Autowired
	private TurnRepository turnRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

		final Restaurant restaurantId = restauranteRepository.findById(createReservationRest.getRestaurantId())
				.orElseThrow(() -> new NotFoundException("RESTURANT_NOYfOUND", "RESTAURANT_NOT_FOUND"));

		final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("TURN_NOYfOUND", "TURN_NOT_FOUND"));

		String locator = generateLocator(restaurantId, createReservationRest);

		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTunr(turn.getName());

		try {
			reservationRepository.save(reservation);

		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return locator;
	}

	private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
			throws BookingException {

		return restaurantId.getName() + createReservationRest.getTurnId();
	}

}
