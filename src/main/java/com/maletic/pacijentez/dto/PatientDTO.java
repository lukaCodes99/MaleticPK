package com.maletic.pacijentez.dto;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
