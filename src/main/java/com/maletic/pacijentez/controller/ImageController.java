package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.model.Photo;
import com.maletic.pacijentez.service.PhotoService;
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

    private final PhotoService photoService;

    public ImageController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/{patientName}/{folderName}/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String patientName,
                                             @PathVariable String folderName,
                                             @PathVariable String imageName) {
        try {
            String decodedPatientName = URLDecoder.decode(patientName, StandardCharsets.UTF_8.toString());
            String decodedFolderName = URLDecoder.decode(folderName, StandardCharsets.UTF_8.toString());
            String decodedImageName = URLDecoder.decode(imageName, StandardCharsets.UTF_8.toString());
            Path imagePath = Paths.get(BASE_DIRECTORY, decodedPatientName, decodedFolderName, decodedImageName);
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                System.out.println("Resource not found or not readable: " + imagePath);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println("Error accessing image: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/photo")
    public ResponseEntity<Void> savePhoto(@RequestBody Photo photo) {
        if (photo == null || photo.getId() == null || photo.getPatientTreatmentId() == null) {
            return ResponseEntity.badRequest().build();
        }

        photo.setPath("/treatmement-images/" + photo.getPatientTreatmentId() + "/" + photo.getId());
        photoService.savePhoto(photo);

        return ResponseEntity.ok().build();
    }
}