

INSERT INTO UserRole (name) VALUES ('admin');
INSERT INTO UserRole (name) VALUES ('head_nurse');
INSERT INTO UserRole (name) VALUES ('doctor');
INSERT INTO UserRole (name) VALUES ('nurse');


INSERT INTO Employee (firstName, lastName, username, password, role) VALUES ('test', 'test', 'luka', '$2a$10$jglFRiklKdMiJDzlt9bxyeBjO0zVOupRFK.KYFsU0jgGF09mnd3WO', (SELECT id FROM UserRole WHERE name = 'admin'));
INSERT INTO Employee (firstName, lastName, username, password, role) VALUES ('Jane', 'Doee', 'jdoe', '$2a$10$GIu76jbFa12LnT1xjis3Uu3ObHd92i4p4yPalK5RSGOpoqp0OdO6u', (SELECT id FROM UserRole WHERE name = 'nurse'));
INSERT INTO Employee (firstName, lastName, username, password, role) VALUES ('Valerija', 'Kelenić', 'vkelenic', '$2a$10$Z1AbXu58jCGia5sHY4//WOnLjt3iSiVOdgJtyxqZn0lM0W.xg7Qp2', (SELECT id FROM UserRole WHERE name = 'head_nurse'));
INSERT INTO Employee (firstName, lastName, username, password, role) VALUES ('Ana', 'Maletić', 'amaletic', '$2a$10$kFgXbRIKQsMboFPymJQOkuAr0FMqW0HOX2MIIYFw68XenGefnyfc6', (SELECT id FROM UserRole WHERE name = 'doctor'));
INSERT INTO Employee (firstName, lastName, username, password, role) VALUES ('Duško', 'Maletić', 'dmaletic', '$2a$10$uhg9YXR5VdVnb3DD/97rLuLY7Uzx6H1feOCbcf9PwQo25m0jnFxgy', (SELECT id FROM UserRole WHERE name = 'doctor'));
INSERT INTO Employee (firstName, lastName, username, password, role) VALUES ('Medicinska', 'Sestra', 'msestra', '$2a$10$1nKCPjFEHJE67o.pcjdDHuGxo0Ldz84/7cTgazikQ6g5d1BhQoXtq', (SELECT id FROM UserRole WHERE name = 'nurse'));


INSERT INTO Treatment (name, price) VALUES ('PRP', 1000);
INSERT INTO Treatment (name, price) VALUES ('PRESAĐIVANJE KOSE', 2000);
INSERT INTO Treatment (name, price) VALUES ('LASER VLASIŠTA', 1500);
INSERT INTO Treatment (name, price) VALUES ('BLEFAROPLASTIKA', 2500);
INSERT INTO Treatment (name, price) VALUES ('MIKRODERMOABRAZIJA', 1200);
INSERT INTO Treatment (name, price) VALUES ('KEMIJSKI PEELING', 1800);
INSERT INTO Treatment (name, price) VALUES ('BOTOX INJEKCIJE', 2200);
INSERT INTO Treatment (name, price) VALUES ('DERMALNI FILERI', 2500);
INSERT INTO Treatment (name, price) VALUES ('LASERSKO UKLANJANJE DLAKA', 2000);

-- Insert Patients
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('John', 'Doe', '123456789');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Jane', 'Smith', '987654321');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Alice', 'Johnson', '555555555');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Bob', 'Brown', '444444444');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Emily', 'Clark', '111111111');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Michael', 'Johnson', '222222222');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Sarah', 'Williams', '333333333');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('David', 'Brown', '444444444');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Laura', 'Jones', '555555555');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('James', 'Garcia', '666666666');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Linda', 'Martinez', '777777777');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Robert', 'Rodriguez', '888888888');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Patricia', 'Martinez', '999999999');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Charles', 'Hernandez', '101010101');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Barbara', 'Lopez', '202020202');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Thomas', 'Gonzalez', '303030303');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Jessica', 'Wilson', '404040404');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Christopher', 'Anderson', '505050505');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Karen', 'Thomas', '606060606');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Daniel', 'Taylor', '707070707');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Nancy', 'Moore', '808080808');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Matthew', 'Jackson', '909090909');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Betty', 'Martin', '111111112');
INSERT INTO Patient (firstName, lastName, phoneNumber) VALUES ('Anthony', 'Lee', '222222223');

-- Insert PatientTreatments
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'John' AND lastName = 'Doe'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 1', 'Zagreb', '2023-10-01 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-01 09:00:00');

INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Jane' AND lastName = 'Smith'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 2', 'Daruvar', '2023-10-02 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-02 10:00:00');

INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Alice' AND lastName = 'Johnson'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 3', 'Zagreb', '2023-10-03 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-03 11:00:00');

INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Bob' AND lastName = 'Brown'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 4', 'Daruvar', '2023-10-04 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-10-04 12:00:00');


-- Insert more PatientTreatments
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Emily' AND lastName = 'Clark'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 5', 'Zagreb', '2023-10-05 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-05 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Michael' AND lastName = 'Johnson'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 6', 'Daruvar', '2023-10-06 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-06 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Sarah' AND lastName = 'Williams'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 7', 'Zagreb', '2023-10-07 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-07 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'David' AND lastName = 'Brown'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 8', 'Daruvar', '2023-10-08 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-10-08 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Laura' AND lastName = 'Jones'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 9', 'Zagreb', '2023-10-09 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-09 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'James' AND lastName = 'Garcia'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 10', 'Daruvar', '2023-10-10 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-10 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Linda' AND lastName = 'Martinez'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 11', 'Zagreb', '2023-10-11 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-11 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Robert' AND lastName = 'Rodriguez'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 12', 'Daruvar', '2023-10-12 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-10-12 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Patricia' AND lastName = 'Martinez'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 13', 'Zagreb', '2023-10-13 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-13 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Charles' AND lastName = 'Hernandez'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 14', 'Daruvar', '2023-10-14 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-14 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Barbara' AND lastName = 'Lopez'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 15', 'Zagreb', '2023-10-15 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-15 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Thomas' AND lastName = 'Gonzalez'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 16', 'Daruvar', '2023-10-16 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-10-16 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Jessica' AND lastName = 'Wilson'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 17', 'Zagreb', '2023-10-17 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-17 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Christopher' AND lastName = 'Anderson'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 18', 'Daruvar', '2023-10-18 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-18 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Karen' AND lastName = 'Thomas'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 19', 'Zagreb', '2023-10-19 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-19 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Daniel' AND lastName = 'Taylor'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 20', 'Daruvar', '2023-10-20 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-10-20 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Nancy' AND lastName = 'Moore'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 21', 'Zagreb', '2023-10-21 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-21 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Matthew' AND lastName = 'Jackson'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 22', 'Daruvar', '2023-10-22 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-22 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Betty' AND lastName = 'Martin'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 23', 'Zagreb', '2023-10-23 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-23 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Anthony' AND lastName = 'Lee'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 24', 'Daruvar', '2023-10-24 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-10-24 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Emily' AND lastName = 'Clark'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 25', 'Zagreb', '2023-10-25 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-25 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Michael' AND lastName = 'Johnson'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 26', 'Daruvar', '2023-10-26 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-26 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Sarah' AND lastName = 'Williams'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 27', 'Zagreb', '2023-10-27 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-27 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'David' AND lastName = 'Brown'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 28', 'Daruvar', '2023-10-28 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-10-28 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Laura' AND lastName = 'Jones'), (SELECT id FROM Treatment WHERE name = 'PRP'), 'Description 29', 'Zagreb', '2023-10-29 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-10-29 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'James' AND lastName = 'Garcia'), (SELECT id FROM Treatment WHERE name = 'PRESAĐIVANJE KOSE'), 'Description 30', 'Daruvar', '2023-10-30 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-10-30 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Linda' AND lastName = 'Martinez'), (SELECT id FROM Treatment WHERE name = 'LASER VLASIŠTA'), 'Description 31', 'Zagreb', '2023-10-31 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-10-31 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Robert' AND lastName = 'Rodriguez'), (SELECT id FROM Treatment WHERE name = 'BLEFAROPLASTIKA'), 'Description 32', 'Daruvar', '2023-11-01 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-01 12:00:00');

-- Insert more PatientTreatments
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES  ((SELECT id FROM Patient WHERE firstName = 'Emily' AND lastName = 'Clark'), (SELECT id FROM Treatment WHERE name = 'MIKRODERMOABRAZIJA'), 'Description 1', 'Zagreb', '2023-11-01 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-01 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Michael' AND lastName = 'Johnson'), (SELECT id FROM Treatment WHERE name = 'KEMIJSKI PEELING'), 'Description 2', 'Daruvar', '2023-11-02 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-02 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Sarah' AND lastName = 'Williams'), (SELECT id FROM Treatment WHERE name = 'BOTOX INJEKCIJE'), 'Description 3', 'Zagreb', '2023-11-03 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-11-03 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'David' AND lastName = 'Brown'), (SELECT id FROM Treatment WHERE name = 'DERMALNI FILERI'), 'Description 4', 'Daruvar', '2023-11-04 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-04 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Laura' AND lastName = 'Jones'), (SELECT id FROM Treatment WHERE name = 'LASERSKO UKLANJANJE DLAKA'), 'Description 5', 'Zagreb', '2023-11-05 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-05 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'James' AND lastName = 'Garcia'), (SELECT id FROM Treatment WHERE name = 'MIKRODERMOABRAZIJA'), 'Description 6', 'Daruvar', '2023-11-06 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-06 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Linda' AND lastName = 'Martinez'), (SELECT id FROM Treatment WHERE name = 'KEMIJSKI PEELING'), 'Description 7', 'Zagreb', '2023-11-07 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-11-07 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Robert' AND lastName = 'Rodriguez'), (SELECT id FROM Treatment WHERE name = 'BOTOX INJEKCIJE'), 'Description 8', 'Daruvar', '2023-11-08 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-08 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Patricia' AND lastName = 'Martinez'), (SELECT id FROM Treatment WHERE name = 'DERMALNI FILERI'), 'Description 9', 'Zagreb', '2023-11-09 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-09 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Charles' AND lastName = 'Hernandez'), (SELECT id FROM Treatment WHERE name = 'LASERSKO UKLANJANJE DLAKA'), 'Description 10', 'Daruvar', '2023-11-10 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-10 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Barbara' AND lastName = 'Lopez'), (SELECT id FROM Treatment WHERE name = 'MIKRODERMOABRAZIJA'), 'Description 11', 'Zagreb', '2023-11-11 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-11-11 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Thomas' AND lastName = 'Gonzalez'), (SELECT id FROM Treatment WHERE name = 'KEMIJSKI PEELING'), 'Description 12', 'Daruvar', '2023-11-12 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-12 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Jessica' AND lastName = 'Wilson'), (SELECT id FROM Treatment WHERE name = 'BOTOX INJEKCIJE'), 'Description 13', 'Zagreb', '2023-11-13 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-13 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Christopher' AND lastName = 'Anderson'), (SELECT id FROM Treatment WHERE name = 'DERMALNI FILERI'), 'Description 14', 'Daruvar', '2023-11-14 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-14 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Karen' AND lastName = 'Thomas'), (SELECT id FROM Treatment WHERE name = 'LASERSKO UKLANJANJE DLAKA'), 'Description 15', 'Zagreb', '2023-11-15 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-11-15 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Daniel' AND lastName = 'Taylor'), (SELECT id FROM Treatment WHERE name = 'MIKRODERMOABRAZIJA'), 'Description 16', 'Daruvar', '2023-11-16 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-16 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Nancy' AND lastName = 'Moore'), (SELECT id FROM Treatment WHERE name = 'KEMIJSKI PEELING'), 'Description 17', 'Zagreb', '2023-11-17 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-17 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Matthew' AND lastName = 'Jackson'), (SELECT id FROM Treatment WHERE name = 'BOTOX INJEKCIJE'), 'Description 18', 'Daruvar', '2023-11-18 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-18 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Betty' AND lastName = 'Martin'), (SELECT id FROM Treatment WHERE name = 'DERMALNI FILERI'), 'Description 19', 'Zagreb', '2023-11-19 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-11-19 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Anthony' AND lastName = 'Lee'), (SELECT id FROM Treatment WHERE name = 'LASERSKO UKLANJANJE DLAKA'), 'Description 20', 'Daruvar', '2023-11-20 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-20 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Emily' AND lastName = 'Clark'), (SELECT id FROM Treatment WHERE name = 'MIKRODERMOABRAZIJA'), 'Description 21', 'Zagreb', '2023-11-21 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-21 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Michael' AND lastName = 'Johnson'), (SELECT id FROM Treatment WHERE name = 'KEMIJSKI PEELING'), 'Description 22', 'Daruvar', '2023-11-22 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-22 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Sarah' AND lastName = 'Williams'), (SELECT id FROM Treatment WHERE name = 'BOTOX INJEKCIJE'), 'Description 23', 'Zagreb', '2023-11-23 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-11-23 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'David' AND lastName = 'Brown'), (SELECT id FROM Treatment WHERE name = 'DERMALNI FILERI'), 'Description 24', 'Daruvar', '2023-11-24 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-24 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Laura' AND lastName = 'Jones'), (SELECT id FROM Treatment WHERE name = 'LASERSKO UKLANJANJE DLAKA'), 'Description 25', 'Zagreb', '2023-11-25 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-25 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'James' AND lastName = 'Garcia'), (SELECT id FROM Treatment WHERE name = 'MIKRODERMOABRAZIJA'), 'Description 26', 'Daruvar', '2023-11-26 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-26 10:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Linda' AND lastName = 'Martinez'), (SELECT id FROM Treatment WHERE name = 'KEMIJSKI PEELING'), 'Description 27', 'Zagreb', '2023-11-27 12:00:00', (SELECT id FROM Employee WHERE username = 'dmaletic'), '2023-11-27 11:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Robert' AND lastName = 'Rodriguez'), (SELECT id FROM Treatment WHERE name = 'BOTOX INJEKCIJE'), 'Description 28', 'Daruvar', '2023-11-28 13:00:00', (SELECT id FROM Employee WHERE username = 'msestra'), '2023-11-28 12:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Patricia' AND lastName = 'Martinez'), (SELECT id FROM Treatment WHERE name = 'DERMALNI FILERI'), 'Description 29', 'Zagreb', '2023-11-29 10:00:00', (SELECT id FROM Employee WHERE username = 'amaletic'), '2023-11-29 09:00:00');
INSERT INTO PatientTreatment (patientId, treatmentId, description, location, date, inserterId, insertedAt) VALUES
    ((SELECT id FROM Patient WHERE firstName = 'Charles' AND lastName = 'Hernandez'), (SELECT id FROM Treatment WHERE name = 'LASERSKO UKLANJANJE DLAKA'), 'Description 30', 'Daruvar', '2023-11-30 11:00:00', (SELECT id FROM Employee WHERE username = 'vkelenic'), '2023-11-30 10:00:00');

