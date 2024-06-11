package com.maletic.pacijentez.mapper;

import com.maletic.pacijentez.dto.TreatmentDTO;
import com.maletic.pacijentez.model.Treatment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TreatmentMapper {

    private ModelMapper modelMapper;

    public TreatmentMapper() {
        this.modelMapper = new ModelMapper();
    }

    public TreatmentDTO mapTreatmentToTreatmentDTO(Treatment treatment) {
        return modelMapper.map(treatment, TreatmentDTO.class);
    }

    public Treatment mapTreatmentDTOToTreatment(TreatmentDTO treatmentDTO) {
        return modelMapper.map(treatmentDTO, Treatment.class);
    }
}
