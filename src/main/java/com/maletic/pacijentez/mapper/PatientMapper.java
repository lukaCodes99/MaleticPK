package com.maletic.pacijentez.mapper;

import com.maletic.pacijentez.dto.PatientDTO;
import com.maletic.pacijentez.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    private ModelMapper modelMapper;

    public PatientMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PatientDTO mapPatientToPatientDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

    public Patient mapPatientDTOToPatient(PatientDTO patientDTO) {
        return modelMapper.map(patientDTO, Patient.class);
    }
}
