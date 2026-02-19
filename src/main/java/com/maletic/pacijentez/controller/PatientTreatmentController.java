package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.command.PatientTreatmentCommand;
import com.maletic.pacijentez.dto.EmployeeDTO;
import com.maletic.pacijentez.dto.PatientDTO;
import com.maletic.pacijentez.dto.PatientTreatmentDTO;
import com.maletic.pacijentez.model.PatientTreatment;
import com.maletic.pacijentez.model.Photo;
import com.maletic.pacijentez.model.UserRole;
import com.maletic.pacijentez.service.EmployeeService;
import com.maletic.pacijentez.service.PatientTreatmentService;
import com.maletic.pacijentez.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/patient-treatment")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientTreatmentController {

    private final PatientTreatmentService patientTreatmentService;
    private final PhotoService photoService;
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<PatientTreatmentDTO>> getAllPatientTreatments(
            @RequestParam(required = false) String patientName,
            @RequestParam(required = false) String treatmentName,
            @RequestParam(required = false) String inserterName,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String appointmentTime // yyyy-MM-dd

    ) {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(0, 5000, sort);

        return ResponseEntity.ok(patientTreatmentService.findFiltered(patientName, treatmentName, inserterName, description, location, appointmentTime, pageable));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<PatientTreatmentDTO>> getPatientTreatmentsByPatientId(@PathVariable Integer id) {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(0, 5000, sort);
        return ResponseEntity.ok(patientTreatmentService.findPatientTreatmentByPatientId_Id(id, pageable));
    }

    @PostMapping("/add")
    public ResponseEntity<PatientTreatmentDTO> savePatientTreatment(@RequestBody PatientTreatmentCommand patientTreatmentDTO) {
        return ResponseEntity.ok(patientTreatmentService.savePatientTreatment(patientTreatmentDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientTreatmentDTO> updatePatientTreatment(@PathVariable Integer id, @RequestBody PatientTreatmentCommand patientTreatment) {
        if(patientTreatmentService.getPatientTreatmentById(id) == null){
            return ResponseEntity.notFound().build();
        }
        patientTreatment.setId(id);
        return ResponseEntity.ok(patientTreatmentService.updatePatientTreatment(patientTreatment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientTreatment> getPatientTreatmentById(@PathVariable Integer id) {
        System.out.println("tretman po id");
        PatientTreatment patientTreatment = patientTreatmentService.getPatientTreatmentById(id);
        if (patientTreatment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patientTreatment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatientTreatment(@PathVariable Integer id) {
        patientTreatmentService.deletePatientTreatment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/photos/{patientTreatmentId}")
    public ResponseEntity<List<Photo>> getPhotosByPatientTreatmentId(@PathVariable Integer patientTreatmentId) {
        return ResponseEntity.ok(photoService.findByPatientTreatmentId(patientTreatmentId));
    }

    @GetMapping("/all-doctors")
    public ResponseEntity<List<EmployeeDTO>> getAllDoctors(){
        return ResponseEntity.ok(employeeService.getAllEmployeesByRole("Doctor"));
    }

    private LocalDateTime parseDateTimeOrReturnNull(String date) {
        if (date != null && !date.equals("null")) {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        }
        else {
            return null;
        }
    }

}
