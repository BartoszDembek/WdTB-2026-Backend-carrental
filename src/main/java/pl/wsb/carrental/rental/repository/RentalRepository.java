package pl.wsb.carrental.rental.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.carrental.rental.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByCustomerEmail(String email);

    List<Rental> findByCarPlateNumber(String plateNumber);
}