package com.maletic.pacijentez.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDTO {

        private Integer id;
        private String name;
        private Long price;
}
