package com.maletic.pacijentez.service;

import com.maletic.pacijentez.dto.TreatmentDTO;
import com.maletic.pacijentez.mapper.TreatmentMapper;
import com.maletic.pacijentez.model.Treatment;
import com.maletic.pacijentez.repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    public List<TreatmentDTO> getAllTreatments() {
        return treatmentRepository.findAll()
                .stream()
                .map(treatmentMapper::mapTreatmentToTreatmentDTO)
                .toList();
    }

    public Treatment getTreatmentById(Integer id) {
        return treatmentRepository.findById(id).orElse(null);
    }

    public TreatmentDTO saveTreatment(TreatmentDTO treatment) {
        Treatment savedTreatment = treatmentRepository.save(treatmentMapper.mapTreatmentDTOToTreatment(treatment));
        return treatmentMapper.mapTreatmentToTreatmentDTO(savedTreatment);
    }

    public TreatmentDTO updateTreatment(TreatmentDTO treatment) {
        if (treatmentRepository.findById(treatment.getId()).isEmpty()) {
            return null;
        }
        Treatment updatedTreatment = treatmentRepository.save(treatmentMapper.mapTreatmentDTOToTreatment(treatment));
        return treatmentMapper.mapTreatmentToTreatmentDTO(updatedTreatment);
    }

    public void deleteTreatment(Integer id) {
        treatmentRepository.deleteById(id);
    }
}
