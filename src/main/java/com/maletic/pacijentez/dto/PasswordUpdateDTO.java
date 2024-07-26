package com.maletic.pacijentez.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdateDTO {
    private Integer employeeId;
    private String oldPassword;
    private String newPassword;
}
