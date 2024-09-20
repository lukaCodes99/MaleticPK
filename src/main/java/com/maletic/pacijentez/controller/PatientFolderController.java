package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.model.PatientFolder;
import com.maletic.pacijentez.model.PatientVisit;
import com.maletic.pacijentez.service.PatientFolderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-folders")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PatientFolderController {

    private final PatientFolderService patientFolderService;

    @GetMapping("/all")
    public ResponseEntity<List<PatientVisit>> getAllPatientVisits() {
        System.out.println("getAllPatientVisits");
        return ResponseEntity.ok(patientFolderService.getAllPatientVisits());
    }

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<List<PatientFolder>> getPatientFolders(@PathVariable String firstName, @PathVariable String lastName) {
        System.out.println("getPatientFolders" + firstName + " " + lastName);
        return ResponseEntity.ok(patientFolderService.getPatientFolders(firstName, lastName));
    }


}