package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.dto.TreatmentDTO;
import com.maletic.pacijentez.model.Treatment;
import com.maletic.pacijentez.service.TreatmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment")
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasAnyAuthority('admin', 'doctor', 'head_nurse')")
public class TreatmentController {

    private TreatmentService treatmentService;


    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TreatmentDTO>> getAllTreatments() {
        return ResponseEntity.ok(treatmentService.getAllTreatments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treatment> getTreatmentById(@PathVariable Integer id) {
        Treatment treatment = treatmentService.getTreatmentById(id);
        if (treatment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(treatment);
    }

    @PostMapping("/save")
    public ResponseEntity<TreatmentDTO> saveTreatment(@RequestBody TreatmentDTO treatment) {
        return ResponseEntity.ok(treatmentService.saveTreatment(treatment));
    }

    @PutMapping("/update")
    public ResponseEntity<TreatmentDTO> updateTreatment(@RequestBody TreatmentDTO treatment) {
        TreatmentDTO updatedTreatmentDTO = treatmentService.updateTreatment(treatment);
        if (updatedTreatmentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTreatmentDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteTreatment(@PathVariable Integer id) {
        treatmentService.deleteTreatment(id);
    }

}
