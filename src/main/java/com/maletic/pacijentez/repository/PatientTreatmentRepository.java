package com.maletic.pacijentez.repository;

public interface PatientTreatmentRepository extends JpaRepository<PatientTreatment, Integer> {

<<<<<<< Updated upstream
=======
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
            " WHERE (:patientNameParam IS NULL OR p.firstName LIKE %:patientNameParam%)" +
            " AND (:treatmentNameParam IS NULL OR t.name LIKE %:treatmentNameParam%)" +
            " AND (:inserterNameParam IS NULL OR i.firstName LIKE %:inserterNameParam%)" +
            " AND (:locationParam IS NULL OR pt.location LIKE %:locationParam%)" +
            " AND (:dateParam IS NULL OR pt.time LIKE %:dateParam%)"
    )
    List<PatientTreatment> findFiltered(String patientNameParam, String treatmentNameParam, String inserterNameParam, String locationParam, String dateParam);
>>>>>>> Stashed changes
}
