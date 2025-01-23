package com.maletic.pacijentez.service;

import com.maletic.pacijentez.dto.PatientDTO;
import com.maletic.pacijentez.mapper.PatientMapper;
import com.maletic.pacijentez.model.Patient;
import com.maletic.pacijentez.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::mapPatientToPatientDTO)
                .toList();
    }

    public List<PatientDTO> getAllFilteredPatients(String firstName, String lastName, String email) {
        if (firstName != null) firstName = firstName.toLowerCase();
        if (lastName != null) lastName = lastName.toLowerCase();
        if (email != null) email = email.toLowerCase();

        Sort sort = Sort.by(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(0, 5000, sort);

        return patientRepository.getFIlteredPatients(firstName, lastName, email, pageable)
                .stream()
                .map(patientMapper::mapPatientToPatientDTO)
                .toList();
    }

    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    public PatientDTO savePatient(PatientDTO patient) {
        Patient patientToSave = patientMapper.mapPatientDTOToPatient(patient);
        return patientMapper.mapPatientToPatientDTO(patientRepository.save(patientToSave));
    }

    public PatientDTO updatePatient(PatientDTO patient) {
        Patient currentPatient = patientRepository.findById(patient.getId()).orElse(null);
        if (currentPatient == null) {
            return null;
        }
        Patient patientToUpdate = patientMapper.mapPatientDTOToPatient(patient);
        return patientMapper.mapPatientToPatientDTO(patientRepository.save(patientToUpdate));
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    public void updateWorkingVersionByPatientId(Integer patientId, String workingVersion) {
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(() -> new IllegalArgumentException("Patient with id " + patientId + " not found"));
        patient.setWorkingVersion(workingVersion);
        patientRepository.save(patient);
    }
}
