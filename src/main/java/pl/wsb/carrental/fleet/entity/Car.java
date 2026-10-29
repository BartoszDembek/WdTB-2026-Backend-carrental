package pl.wsb.carrental.fleet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * Samochód z floty wypożyczalni: dane do listy i filtrowania (marka, model, kolor, liczba miejsc, moc silnika)
 * oraz stawka dzienna i status dostępności.
 */
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false, length = 40)
    private String brand;

    @Column(name = "model", nullable = false, length = 40)
    private String model;

    @Column(name = "plate_number", nullable = false, unique = true, length = 10)
    private String plateNumber;

    @Column(name = "color", nullable = false, length = 30)
    private String color;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @Column(name = "engine_power", nullable = false)
    private Integer enginePower;

    @Column(name = "daily_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal dailyRate;

    @Column(name = "available", nullable = false)
    private Boolean available;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private CarStatus status;

    protected Car() {
    }

    public Car(String brand, String model, String plateNumber, String color, Integer seats,
               Integer enginePower, BigDecimal dailyRate, Boolean available, CarStatus status) {
        this.brand = brand;
        this.model = model;
        this.plateNumber = plateNumber;
        this.color = color;
        this.seats = seats;
        this.enginePower = enginePower;
        this.dailyRate = dailyRate;
        this.available = available;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getColor() {
        return color;
    }

    public Integer getSeats() {
        return seats;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public CarStatus getStatus() {
        return status;
    }
}
