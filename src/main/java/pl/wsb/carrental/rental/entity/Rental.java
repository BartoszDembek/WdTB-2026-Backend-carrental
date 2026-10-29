package pl.wsb.carrental.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Wynajem samochodu: numer, termin, miejsce odbioru, kwota i status.
 * Relacje do samochodu i klienta dojdą na kolejnych zajęciach.
 */
@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_number", nullable = false, unique = true, length = 20)
    private String reservationNumber;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "pickup_city", nullable = false, length = 40)
    private String pickupCity;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private RentalStatus status;

    protected Rental() {
    }

    public Rental(String reservationNumber, LocalDate startDate, LocalDate endDate,
                  String pickupCity, BigDecimal totalPrice, RentalStatus status) {
        this.reservationNumber = reservationNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickupCity = pickupCity;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public RentalStatus getStatus() {
        return status;
    }
}
