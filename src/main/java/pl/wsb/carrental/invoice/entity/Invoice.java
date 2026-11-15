package pl.wsb.carrental.invoice.entity;

import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import pl.wsb.carrental.rental.entity.Rental;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "paid")
    private boolean paid;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rental_id", unique = true)
    private Rental rental;
}