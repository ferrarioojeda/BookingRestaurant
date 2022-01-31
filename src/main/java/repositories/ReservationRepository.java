package repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	Optional<Reservation> findById(Long id);
	Optional<Reservation> findByLocation(String locator);
	@Modifying
	@Transactional
	Optional<Reservation> deleteByLocation(String locator);
	Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);


}
