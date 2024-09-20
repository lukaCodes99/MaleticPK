package com.maletic.pacijentez.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    private static final String BASE_DIRECTORY = "C:/Users/Luka/Desktop/test-slike";

    @GetMapping("/{patientName}/{folderName}/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String patientName, @PathVariable String folderName, @PathVariable String imageName) {
        try {
            String decodedPatientName = URLDecoder.decode(patientName, StandardCharsets.UTF_8.toString());
            String decodedFolderName = URLDecoder.decode(folderName, StandardCharsets.UTF_8.toString());
            String decodedImageName = URLDecoder.decode(imageName, StandardCharsets.UTF_8.toString());
            Path imagePath = Paths.get(BASE_DIRECTORY, decodedPatientName, decodedFolderName, decodedImageName);
            System.out.println("Accessing image at path: " + imagePath.toString());
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                System.out.println("Resource not found or not readable: " + imagePath.toString());
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println("Error accessing image: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}