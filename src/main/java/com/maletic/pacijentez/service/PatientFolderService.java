package com.maletic.pacijentez.service;

import com.maletic.pacijentez.model.PatientFolder;
import com.maletic.pacijentez.model.PatientVisit;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientFolderService {

    private static final String BASE_DIRECTORY = "C:\\Users\\Luka\\Desktop\\test-slike";

    public List<PatientFolder> getPatientFolders(String firstName, String lastName) {
        List<PatientFolder> patientFolders = new ArrayList<>();
        String patientFolderPath = BASE_DIRECTORY + "\\" + firstName + " " + lastName;
        File patientFolder = new File(patientFolderPath);

        if (patientFolder.exists() && patientFolder.isDirectory()) {
            for (File dateFolder : patientFolder.listFiles()) {
                if (dateFolder.isDirectory()) {
                    PatientFolder patientFolderModel = new PatientFolder();
                    patientFolderModel.setFolderName(dateFolder.getName());
                    patientFolderModel.setDate(extractDateFromFolderName(dateFolder.getName(), firstName, lastName));
                    List<String> images = new ArrayList<>();
                    for (File imageFile : dateFolder.listFiles()) {
                        if (imageFile.isFile() && imageFile.getName().endsWith(".png")) {
                            images.add(imageFile.getName());
                        }
                    }
                    patientFolderModel.setImages(images);
                    patientFolders.add(patientFolderModel);
                }
            }
        }
        return patientFolders;
    }

    public List<PatientVisit> getAllPatientVisits() {
        List<PatientVisit> visits = new ArrayList<>();
        File baseDir = new File(BASE_DIRECTORY);

        if (baseDir.exists() && baseDir.isDirectory()) {
            for (File patientFolder : baseDir.listFiles()) {
                if (patientFolder.isDirectory()) {
                    String[] nameParts = patientFolder.getName().split(" ");
                    if (nameParts.length >= 2) {
                        String fullName = nameParts[0] + " " + nameParts[1];
                        visits.add(new PatientVisit(visits.size() + 1, fullName, "Unknown Treatment"));
                    }
                }
            }
        }
        return visits;
    }

    private String extractDateFromFolderName(String folderName, String firstName, String lastName) {
        // Assuming the folder name format is "firstname lastname dd.MM.yyyy."
        String[] parts = folderName.split(" ");
        return parts.length > 2 ? parts[2] : "";
    }
}
