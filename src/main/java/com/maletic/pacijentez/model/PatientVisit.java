package com.maletic.pacijentez.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientVisit {
    private int id;
    private String fullName;
    private String treatmentName;
}
