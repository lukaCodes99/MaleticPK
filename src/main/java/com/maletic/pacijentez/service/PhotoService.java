package com.maletic.pacijentez.service;

import com.maletic.pacijentez.model.Photo;
import com.maletic.pacijentez.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    private PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    /**
     kada uploadamo sliku, spremamo id, path slike i id tretmana pacijenta
     ako baš u file sistemu želimo naći, sve slike će biti u folderima koji će biti odvojeni prema id tretmana pacijenta
     *
     */
    public void savePhoto(Photo photo) {
        //path mora biti /treatmement-images/{patientTreatmentId}/{photoId}
        photoRepository.save(photo);
    }

    public List<Photo> findByPatientTreatmentId(Integer patientTreatmentId) {
        return photoRepository.findByPatientTreatmentId(patientTreatmentId);
    }

}
