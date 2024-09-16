package com.maletic.pacijentez.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientTreatmentCommand {

    private Integer id=null;
    private Integer patientId;
    private Integer treatmentId;
    private Integer inserterId;
    private String description;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

}
