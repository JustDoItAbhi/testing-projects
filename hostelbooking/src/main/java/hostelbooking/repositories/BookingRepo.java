package hostelbooking.repositories;

import hostelbooking.models.Booking;
import hostelbooking.models.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
    List<Booking> findBookingsByGuest(Guests guest);
}
