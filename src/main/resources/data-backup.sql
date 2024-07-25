-- Insert into Employee
INSERT INTO Employee (firstName, lastName, username, password, role) VALUES
( 'John', 'Doe', 'jdoe', 'password1', 'Doctor'),
( 'Jane', 'Smith', 'jsmith', 'password2', 'Nurse');
--(3, 'Jane', 'Doe', 'jdoe', 'password3', 'HeadNurse');

-- Insert into Patient
INSERT INTO Patient ( firstName, lastName, phoneNumber) VALUES
('Patient', 'One', '1234567890'),
('Patient', 'Two', '2345678901');

-- Insert into Treatment
INSERT INTO Treatment ( name, price) VALUES
( 'Treatment One', 100),
( 'Treatment Two', 200);

-- Insert into PatientTreatment
-- INSERT INTO PatientTreatment (patientId, treatmentId, inserterId, insertedAt) VALUES
-- (1, 1, 1, '2023-01-01T00:00:00'),
-- (1, 2, 2, '2023-01-02T00:00:00');