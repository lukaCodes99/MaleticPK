package com.maletic.pacijentez.dto;

import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDTO {

        private Integer id;
        private String name;
        private Long price;
}
