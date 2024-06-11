package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.dto.PatientTreatmentDTO;
import com.maletic.pacijentez.model.PatientTreatment;
import com.maletic.pacijentez.service.PatientTreatmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient-treatment")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientTreatmentController {

    private PatientTreatmentService patientTreatmentService;

    public PatientTreatmentController(PatientTreatmentService patientTreatmentService) {
        this.patientTreatmentService = patientTreatmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientTreatmentDTO>> getAllPatientTreatments(){
        return ResponseEntity.ok(patientTreatmentService.findAllTreatments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientTreatment> getPatientTreatmentById(@PathVariable Integer id){
        PatientTreatment patientTreatment = patientTreatmentService.getPatientTreatmentById(id);
        if(patientTreatment == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patientTreatment);
    }

    @PostMapping("/save")
    public ResponseEntity<PatientTreatmentDTO> savePatientTreatment(@RequestBody PatientTreatmentDTO patientTreatment){
        return ResponseEntity.ok(patientTreatmentService.savePatientTreatment(patientTreatment));
    }

    @PutMapping("/update")
    public ResponseEntity<PatientTreatmentDTO> updatePatientTreatment(@RequestBody PatientTreatmentDTO patientTreatment){
        PatientTreatmentDTO updatedPatientTreatmentDTO = patientTreatmentService.updatePatientTreatment(patientTreatment);
        if(updatedPatientTreatmentDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPatientTreatmentDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deletePatientTreatment(@PathVariable Integer id){
        patientTreatmentService.deletePatientTreatment(id);
    }


}
