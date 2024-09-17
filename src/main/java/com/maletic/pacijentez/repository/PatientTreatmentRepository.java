package com.maletic.pacijentez.repository;

import com.maletic.pacijentez.model.PatientTreatment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientTreatmentRepository extends JpaRepository<PatientTreatment, Integer> {

    @Query("SELECT pt FROM PatientTreatment pt " +
            " JOIN FETCH pt.patientId p" +
            " JOIN FETCH pt.treatmentId t" +
            " JOIN FETCH pt.inserterId i"
    )
    List<PatientTreatment> findAll();

    @Query("SELECT pt FROM PatientTreatment pt " +
            " JOIN FETCH pt.patientId p" +
            " JOIN FETCH pt.treatmentId t" +
            " JOIN FETCH pt.inserterId i" +
            " WHERE (:patientNameParam IS NULL OR (LOWER(p.firstName) LIKE %:patientNameParam% OR LOWER(p.lastName) LIKE %:patientNameParam%))" +
            " AND (:descriptionParam IS NULL OR LOWER(pt.description) LIKE %:descriptionParam%)" +
            " AND (:treatmentNameParam IS NULL OR LOWER(t.name) LIKE %:treatmentNameParam%)" +
            " AND (:inserterNameParam IS NULL OR LOWER(i.firstName) LIKE %:inserterNameParam%)" +
            " AND (:locationParam IS NULL OR LOWER(pt.location) LIKE %:locationParam%)" +
            " AND ((cast(:appointmentTimeFrom as timestamp ) IS NULL) OR pt.insertedAt >= :appointmentTimeFrom)" +
            " AND ((cast(:appointmentTimeTo as timestamp ) IS NULL) OR pt.insertedAt <= :appointmentTimeTo)"
    )
    List<PatientTreatment> findFiltered(@Param("patientNameParam") String patientName,@Param("treatmentNameParam") String treatmentName,
                                       @Param("inserterNameParam") String inserterName,@Param("locationParam") String location,
                                       @Param("descriptionParam") String description,
                                       @Param("appointmentTimeFrom") LocalDateTime appointmentTimeFrom,
                                       @Param("appointmentTimeTo") LocalDateTime appointmentTimeTo,
                                        Pageable pageable
    );

    List<PatientTreatment> findPatientTreatmentByPatientId_Id(Integer id, Pageable pageable);

}
