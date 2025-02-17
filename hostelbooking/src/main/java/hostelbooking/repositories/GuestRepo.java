package hostelbooking.repositories;

import hostelbooking.models.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepo extends JpaRepository<Guests,String> {
    Optional<Guests> findByEmail(String email);
}
