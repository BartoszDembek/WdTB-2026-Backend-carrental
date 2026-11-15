package pl.wsb.carrental.invoice.entity;

import jakarta.persistence.*;
import pl.wsb.carrental.rental.entity.Rental;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;
    private LocalDate issueDate;
    private BigDecimal amount;
    private boolean paid;

    @OneToOne(optional = false)
    @JoinColumn(name = "rental_id", unique = true)
    private Rental rental;
}