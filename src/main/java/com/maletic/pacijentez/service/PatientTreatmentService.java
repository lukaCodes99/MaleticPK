package com.maletic.pacijentez.service;

import com.maletic.pacijentez.dto.PatientTreatmentDTO;
import com.maletic.pacijentez.mapper.PatientTreatmentMapper;
import com.maletic.pacijentez.model.Patient;
import com.maletic.pacijentez.model.PatientTreatment;
import com.maletic.pacijentez.repository.PatientTreatmentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PatientTreatmentService {

    private final PatientTreatmentRepository patientTreatmentRepository;
    private PatientTreatmentMapper patientTreatmentMapper;

    @Transactional
    public PatientTreatment getPatientTreatmentById(Integer id) {
        return patientTreatmentRepository.findById(id).orElse(null);
    }

    public List<PatientTreatmentDTO> findAllTreatments() {
        return patientTreatmentRepository.findAll()
                        .stream()
                        .map(patientTreatmentMapper::mapPTtoPTdto)
                        .collect(Collectors.toList());
    }
    public PatientTreatmentDTO savePatientTreatment(PatientTreatmentDTO patientTreatmentDTO) {
        PatientTreatment patientTreatment = patientTreatmentMapper.mapPTdtoToPT(patientTreatmentDTO);
        return patientTreatmentMapper.mapPTtoPTdto(patientTreatmentRepository.save(patientTreatment));
    }

    public PatientTreatmentDTO updatePatientTreatment(PatientTreatmentDTO patientTreatment) {
        if(patientTreatmentRepository.findById(patientTreatment.getId()).isEmpty()){
            return null;
        }
        PatientTreatment updatedPatientTreatment = patientTreatmentMapper.mapPTdtoToPT(patientTreatment);
        return patientTreatmentMapper.mapPTtoPTdto(patientTreatmentRepository.save(updatedPatientTreatment));
    }

    public void deletePatientTreatment(Integer id) {
        patientTreatmentRepository.deleteById(id);
    }
}
