package com.maletic.pacijentez.repository;

import com.maletic.pacijentez.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    List<Photo> findByPatientTreatmentId(Integer patientTreatmentIdId);
}
