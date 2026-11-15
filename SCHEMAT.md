# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 8 (w tym tabele łączące @ManyToMany: car_equipment) · kolumny: 50 · relacje: 4 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 2 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| car | Car | 10 | — |
| customer | Customer | 9 | — |
| equipment | Equipment | 5 | — |
| invoice | Invoice | 6 | rental_id |
| rental | Rental | 10 | car_id, customer_id, handled_by_id |
| service_record | ServiceRecord | 5 | car_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    car {
        Long id PK
        Boolean available
        String brand
        String color
        BigDecimal daily_rate
        Integer engine_power
        String model
        String plate_number
        Integer seats
        CarStatus status
    }
    customer {
        Long id PK
        String city
        String email
        String full_name
        String license_number
        String phone
        String postal_code
        LocalDate registered_on
        String street
    }
    equipment {
        Long id PK
        String category
        BigDecimal daily_fee
        String description
        String name
    }
    invoice {
        Long id PK
        BigDecimal amount
        String invoice_number
        LocalDate issue_date
        boolean paid
        Long rental_id FK
    }
    rental {
        Long id PK
        Long car_id FK
        Long customer_id FK
        LocalDate end_date
        Long handled_by_id FK
        String pickup_city
        String reservation_number
        LocalDate start_date
        RentalStatus status
        BigDecimal total_price
    }
    service_record {
        Long id PK
        Long car_id FK
        BigDecimal cost
        String description
        LocalDate service_date
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    car ||--o{ rental : "car_id"
    car ||--o{ service_record : "car_id"
    car }o--o{ equipment : "car_equipment"
    customer ||--o{ rental : "customer_id"
    rental ||--o| invoice : "rental_id"
    user_account |o--o{ rental : "handled_by_id"
```
