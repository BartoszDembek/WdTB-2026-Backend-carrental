-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dane do własnych tabel projektu (każda tabela ma osobną sekcję na końcu pliku).
insert into user_account (email, display_name, role, created_at) values
    ('wrx81977@student.wroclaw.merito.pl',   'Bartosz',   'USER',    current_timestamp),
    ('wrx81939@student.wroclaw.merito.pl',  'Rafał',  'USER',    current_timestamp),
    ('biuro@carrental.pl',                  'Biuro wynajmu', 'PARTNER', current_timestamp);

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
-- Klucze obce: customer_id, car_id, handled_by_id (user_account).
insert into rental (reservation_number, start_date, end_date, pickup_city, total_price, status, customer_id, car_id, handled_by_id) values
    ('WYN-2026-001', '2026-10-05', '2026-10-09', 'Wrocław', 596.00, 'RETURNED',
    (select id from customer where email = 'anna.kowalska@example.com'),
    (select id from car where plate_number = 'DW 12345'),
    (select id from user_account where email = 'biuro@carrental.pl')),
    ('WYN-2026-002', '2026-10-26', '2026-10-30', 'Wrocław', 556.00, 'ACTIVE',
    (select id from customer where email = 'jan.nowak@example.com'),
    (select id from car where plate_number = 'DZ 24680'),
    (select id from user_account where email = 'biuro@carrental.pl')),
    ('WYN-2026-003', '2026-11-02', '2026-11-06', 'Wrocław', 996.00, 'PLANNED',
    (select id from customer where email = 'ewa.wisniewska@example.com'),
    (select id from car where plate_number = 'DWX 13579'),
    (select id from user_account where email = 'wrx81977@student.wroclaw.merito.pl'));

-- ===== LAB 03 · service_record =====
-- Tabela podrzędna względem car. Klucz obcy: car_id.
insert into service_record (service_date, description, cost, car_id) values
    ('2026-09-10', 'Wymiana oleju i filtrów',     450.00, (select id from car where plate_number = 'DW 12345')),
    ('2026-10-02', 'Wymiana klocków hamulcowych', 780.00, (select id from car where plate_number = 'DW 67890')),
    ('2026-11-10', 'Przegląd techniczny',         320.00, (select id from car where plate_number = 'DWX 13579')),
    ('2026-11-12', 'Wymiana rozrządu',           2100.00, (select id from car where plate_number = 'DWX 13579'));

-- ===== LAB 03 · invoice =====
-- Tabela podrzędna względem rental (relacja 1:1). Klucz obcy: rental_id.
insert into invoice (invoice_number, issue_date, amount, paid, rental_id) values
    ('FV/2026/10/001', '2026-10-09', 596.00, true,  (select id from rental where reservation_number = 'WYN-2026-001')),
    ('FV/2026/10/002', '2026-10-26', 556.00, false, (select id from rental where reservation_number = 'WYN-2026-002')),
    ('FV/2026/11/003', '2026-11-02', 996.00, false, (select id from rental where reservation_number = 'WYN-2026-003'));
-- ===== LAB 02 · equipment =====
insert into equipment (name, description, category, daily_fee) values
    ('Nawigacja GPS',     'Wbudowana nawigacja z mapami Europy', 'ELEKTRONIKA', 15.00),
    ('Fotelik dziecięcy', 'Fotelik 9-36 kg','BEZPIECZENSTWO', 10.00),
    ('Klimatyzacja',      'Klimatyzacja automatyczna','KOMFORT',     0.00),
    ('Hak holowniczy',    'Hak z wyjmowaną kulą','TRANSPORT',   25.00);

-- ===== LAB 02 · car_equipment (tabela łącząca wiele-do-wielu) =====
insert into car_equipment (car_id, equipment_id) values
    ((select id from car where plate_number = 'DW 12345'),  (select id from equipment where name = 'Klimatyzacja')),
    ((select id from car where plate_number = 'DW 12345'),  (select id from equipment where name = 'Nawigacja GPS')),
    ((select id from car where plate_number = 'DW 67890'),  (select id from equipment where name = 'Klimatyzacja')),
    ((select id from car where plate_number = 'DW 67890'),  (select id from equipment where name = 'Hak holowniczy')),
    ((select id from car where plate_number = 'DZ 24680'),  (select id from equipment where name = 'Klimatyzacja')),
    ((select id from car where plate_number = 'DWX 13579'), (select id from equipment where name = 'Klimatyzacja')),
    ((select id from car where plate_number = 'DWX 13579'), (select id from equipment where name = 'Nawigacja GPS')),
    ((select id from car where plate_number = 'DWX 13579'), (select id from equipment where name = 'Fotelik dziecięcy'));