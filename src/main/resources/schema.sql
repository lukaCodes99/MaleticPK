CREATE TABLE IF NOT EXISTS Employee (
                          id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          firstName varchar(255),
                          lastName varchar(255),
                          username varchar(255),
                          password varchar(255),
                          role varchar(255)
);

CREATE TABLE IF NOT EXISTS Patient (
                         id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         firstName varchar(255),
                         lastName varchar(255),
                         phoneNumber varchar(255)
);

CREATE TABLE IF NOT EXISTS Treatment (
                           id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                           name varchar(255),
                           price bigint
);

CREATE TABLE IF NOT EXISTS PatientTreatment (
                            id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                            patientId integer,
                            treatmentId integer,
                            inserterId integer,
                            insertedAt timestamp(6),
                            FOREIGN KEY (patientId) REFERENCES Patient(id),
                            FOREIGN KEY (treatmentId) REFERENCES Treatment(id),
                            FOREIGN KEY (inserterId) REFERENCES Employee(id)
);