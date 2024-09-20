package com.maletic.pacijentez.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientFolder {

    private String folderName;
    private String date;
    private List<String> images;

}
