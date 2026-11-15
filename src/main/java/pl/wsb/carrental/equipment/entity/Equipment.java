package pl.wsb.carrental.equipment.entity;

import jakarta.persistence.*;
import pl.wsb.carrental.car.entity.Car;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "daily_fee")
    private BigDecimal dailyFee;

    @ManyToMany(mappedBy = "equipment")
    private Set<Car> cars = new HashSet<>();
}