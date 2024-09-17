package com.maletic.pacijentez.service;

import com.maletic.pacijentez.command.PatientTreatmentCommand;
import com.maletic.pacijentez.dto.PatientTreatmentDTO;
import com.maletic.pacijentez.mapper.PatientTreatmentMapper;
import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.model.PatientTreatment;
import com.maletic.pacijentez.repository.EmployeeRepository;
import com.maletic.pacijentez.repository.PatientTreatmentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientTreatmentService {

    private final PatientTreatmentRepository patientTreatmentRepository;
    private PatientTreatmentMapper patientTreatmentMapper;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public PatientTreatment getPatientTreatmentById(Integer id) {
        return patientTreatmentRepository.findById(id).orElse(null);
    }

    public List<PatientTreatmentDTO> findAllTreatments() {
        return patientTreatmentRepository.findAll()
                        .stream()
                        .map(patientTreatmentMapper::mapPTtoPTdto)
                        .toList();
    }
    public PatientTreatmentDTO savePatientTreatment(PatientTreatmentCommand patientTreatmentDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        PatientTreatment patientTreatment = patientTreatmentMapper.mapCommandToEntity(patientTreatmentDTO);
        patientTreatment.setInsertedAt(LocalDateTime.now());
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        patientTreatment.setInserterId(employee);
        return patientTreatmentMapper.mapPTtoPTdto(patientTreatmentRepository.save(patientTreatment));
    }

    public PatientTreatmentDTO updatePatientTreatment(PatientTreatmentCommand patientTreatment) {
        PatientTreatment exstistingTreatment = patientTreatmentRepository.findById(patientTreatment.getId()).orElse(null);
        if(exstistingTreatment == null){
            return null;
        }
        System.out.println("inserted at" + exstistingTreatment.getInsertedAt());
        PatientTreatment updatedPatientTreatment = patientTreatmentMapper.mapCommandToEntity(patientTreatment);
        updatedPatientTreatment.setInsertedAt(exstistingTreatment.getInsertedAt());
        return patientTreatmentMapper.mapPTtoPTdto(patientTreatmentRepository.save(updatedPatientTreatment));
    }

    public void deletePatientTreatment(Integer id) {
        patientTreatmentRepository.deleteById(id);
    }


    public List<PatientTreatmentDTO> findFiltered(String patientName, String treatmentName, String inserterName,
                                                  String description, String location, String date, Pageable pageable) {
        LocalDateTime appointmentDateFrom = parseDateTimeOrReturnNull(date, false); // Start of the day
        LocalDateTime appointmentDateTo = parseDateTimeOrReturnNull(date, true); // End of the day

        patientName = convertStringToLowerCase(patientName);
        treatmentName = convertStringToLowerCase(treatmentName);
        inserterName = convertStringToLowerCase(inserterName);
        description = convertStringToLowerCase(description);

        return patientTreatmentRepository.findFiltered(patientName, treatmentName, inserterName, location, description, appointmentDateFrom, appointmentDateTo, pageable)
                .stream()
                .map(patientTreatmentMapper::mapPTtoPTdto)
                .toList();
    }

    private LocalDate parseDateOrReturnNull(String date) {
        if (date != null && !date.equals("null")) {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            return null;
        }
    }

    private LocalDateTime parseDateTimeOrReturnNull(String date, boolean isEndOfDay) {
        if (date != null && !date.equals("null")) {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (isEndOfDay) {
                return localDate.atTime(23, 59, 59);
            } else {
                return localDate.atTime(0, 0, 0);
            }
        } else {
            return null;
        }
    }

    private String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

        public List<PatientTreatmentDTO> findPatientTreatmentByPatientId_Id(Integer id, Pageable pageable) {
        return patientTreatmentRepository.findPatientTreatmentByPatientId_Id(id, pageable)
                .stream()
                .map(patientTreatmentMapper::mapPTtoPTdto)
                .collect(Collectors.toList());
    }

    private String convertStringToLowerCase(String string) {
        return string == null ? null : string.toLowerCase();
    }


}
