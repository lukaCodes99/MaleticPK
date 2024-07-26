package com.maletic.pacijentez.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientTreatmentDTO {

    private Integer id;
    private Integer patientId;
    private Integer treatmentId;
    private Integer inserterId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertedAt;


}
