package com.maletic.pacijentez.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PatientTreatment")
public class PatientTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "treatmentId", referencedColumnName = "id")
    private Treatment treatmentId;

    @ManyToOne
    @JoinColumn(name = "inserterId", referencedColumnName = "id")
    private Employee inserterId;

    @Column(name = "insertedAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertedAt;


}