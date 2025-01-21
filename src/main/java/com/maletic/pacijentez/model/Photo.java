package com.maletic.pacijentez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Photo")
public class Photo {

    @Id
    private Integer id;

    private String path;

    private Integer patientTreatmentId;

}
