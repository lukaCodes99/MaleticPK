package com.maletic.pacijentez.repository;

import com.maletic.pacijentez.model.PatientTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientTreatmentRepository extends JpaRepository<PatientTreatment, Integer> {

    @Query("SELECT pt FROM PatientTreatment pt " +
            " JOIN FETCH pt.patientId p" +
            " JOIN FETCH pt.treatmentId t" +
            " JOIN FETCH pt.inserterId i"
    )
    List<PatientTreatment> findAll();
}
