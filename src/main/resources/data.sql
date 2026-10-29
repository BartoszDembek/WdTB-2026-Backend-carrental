-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dane do własnych tabel projektu (każda tabela ma osobną sekcję na końcu pliku).
insert into user_account (email, display_name, role, created_at) values
    ('wrx81977@student.wroclaw.merito.pl',   'Bartosz',   'USER',    current_timestamp),
    ('wrx81939@student.wroclaw.merito.pl',  'Rafał',  'USER',    current_timestamp),
    ('biuro@carrental.pl',                  'Biuro wynajmu', 'PARTNER', current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);

-- ===== LAB 02 · car =====
insert into car (brand, model, plate_number, color, seats, engine_power, daily_rate, available, status) values
    ('Toyota',      'Corolla',  'DW 12345',  'biały',      5, 132, 149.00, true,  'AVAILABLE'),
    ('Volkswagen',  'Passat',   'DW 67890',  'grafitowy',  5, 150, 189.00, true,  'AVAILABLE'),
    ('Ford',        'Focus',    'DZ 24680',  'czerwony',   5, 125, 139.00, false, 'RENTED'),
    ('BMW',         'Seria 3',  'DWX 13579', 'czarny',     5, 184, 249.00, false, 'SERVICE');

-- ===== LAB 02 · customer =====
insert into customer (full_name, email, phone, license_number, registered_on, street, city, postal_code) values
    ('Anna Kowalska',   'anna.kowalska@example.com',   '600100200', 'DOW/1234567', '2026-09-15', 'Ruska 12',      'Wrocław', '50-079'),
    ('Jan Nowak',       'jan.nowak@example.com',       null,        'DOW/2345678', '2026-10-01', null,            null,      null),
    ('Ewa Wiśniewska',  'ewa.wisniewska@example.com',  '600500600', 'DOW/3456789', '2026-10-20', 'Świdnicka 3/4', 'Wrocław', '50-066');

-- ===== LAB 02 · rental =====
insert into rental (reservation_number, start_date, end_date, pickup_city, total_price, status) values
    ('WYN-2026-001', '2026-10-05', '2026-10-09', 'Wrocław', 596.00, 'RETURNED'),
    ('WYN-2026-002', '2026-10-26', '2026-10-30', 'Wrocław', 556.00, 'ACTIVE'),
    ('WYN-2026-003', '2026-11-02', '2026-11-06', 'Wrocław', 996.00, 'PLANNED');
