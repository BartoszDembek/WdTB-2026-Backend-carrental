package pl.wsb.carrental.equipment.entity;

import jakarta.persistence.*;
import pl.wsb.carrental.car.entity.Car;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "equipment")
    private Set<Car> cars = new HashSet<>();
}