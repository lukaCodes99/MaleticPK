package com.maletic.pacijentez.dto;

import jakarta.persistence.Column;
import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String role;

}
