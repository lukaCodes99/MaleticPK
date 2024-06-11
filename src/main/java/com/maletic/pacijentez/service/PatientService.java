package com.maletic.pacijentez.service;

import com.maletic.pacijentez.dto.PatientDTO;
import com.maletic.pacijentez.mapper.PatientMapper;
import com.maletic.pacijentez.model.Patient;
import com.maletic.pacijentez.repository.PatientRepository;
import lombok.AllArgsConstructor;
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
                .collect(java.util.stream.Collectors.toList());
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
}
