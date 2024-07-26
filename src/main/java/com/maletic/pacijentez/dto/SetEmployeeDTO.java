package com.maletic.pacijentez.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetEmployeeDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;

}
