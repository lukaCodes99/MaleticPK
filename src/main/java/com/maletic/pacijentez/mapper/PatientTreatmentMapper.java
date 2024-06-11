package com.maletic.pacijentez.mapper;

import com.maletic.pacijentez.dto.PatientTreatmentDTO;
import com.maletic.pacijentez.model.PatientTreatment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PatientTreatmentMapper {

    private ModelMapper modelMapper;

    public PatientTreatmentMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PatientTreatmentDTO mapPTtoPTdto(PatientTreatment patientTreatment) {
        return modelMapper.map(patientTreatment, PatientTreatmentDTO.class);
    }

    public PatientTreatment mapPTdtoToPT(PatientTreatmentDTO patientTreatmentDTO) {
        return modelMapper.map(patientTreatmentDTO, PatientTreatment.class);
    }
}
