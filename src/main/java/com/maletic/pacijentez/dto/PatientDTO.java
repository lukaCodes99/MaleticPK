package com.maletic.pacijentez.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
