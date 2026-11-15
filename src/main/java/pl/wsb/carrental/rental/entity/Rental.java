package pl.wsb.carrental.rental.entity;

import jakarta.persistence.*;
import pl.wsb.carrental.account.domain.UserAccount;
import pl.wsb.carrental.car.entity.Car;
import pl.wsb.carrental.customer.entity.Customer;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "handled_by_id")
    private UserAccount handledBy;

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
