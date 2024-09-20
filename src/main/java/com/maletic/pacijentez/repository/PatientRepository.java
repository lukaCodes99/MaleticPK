package com.maletic.pacijentez.repository;

import com.maletic.pacijentez.model.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("SELECT p FROM Patient p WHERE " +
            "(:firstNameParam IS NULL OR LOWER(p.firstName) LIKE %:firstNameParam%) AND " +
            "(:lastNameParam IS NULL OR LOWER(p.lastName) LIKE %:lastNameParam%) AND " +
            "(:emailParam IS NULL OR LOWER(p.email) LIKE %:emailParam%)"
    )
    List<Patient> getFIlteredPatients(@Param("firstNameParam") String firstName,
                    @Param("lastNameParam") String lastName,
                    @Param("emailParam") String email,
                    Pageable pageable
    );

}
