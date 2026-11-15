package pl.wsb.carrental.service_record.entity;

import jakarta.persistence.*;
import pl.wsb.carrental.car.entity.Car;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ServiceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate serviceDate;
    private String description;
    private BigDecimal cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;
}