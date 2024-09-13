package com.maletic.pacijentez.service;

public class PatientTreatmentService {

<<<<<<< Updated upstream
=======
    private final PatientTreatmentRepository patientTreatmentRepository;
    private PatientTreatmentMapper patientTreatmentMapper;

    @Transactional
    public PatientTreatment getPatientTreatmentById(Integer id) {
        return patientTreatmentRepository.findById(id).orElse(null);
    }

    public List<PatientTreatmentDTO> findAllTreatments() {
        return patientTreatmentRepository.findAll()
                        .stream()
                        .map(patientTreatmentMapper::mapPTtoPTdto)
                        .collect(Collectors.toList());
    }
    public PatientTreatmentDTO savePatientTreatment(PatientTreatmentDTO patientTreatmentDTO) {
        PatientTreatment patientTreatment = patientTreatmentMapper.mapPTdtoToPT(patientTreatmentDTO);
        return patientTreatmentMapper.mapPTtoPTdto(patientTreatmentRepository.save(patientTreatment));
    }

    public PatientTreatmentDTO updatePatientTreatment(PatientTreatmentDTO patientTreatment) {
        if(patientTreatmentRepository.findById(patientTreatment.getId()).isEmpty()){
            return null;
        }
        PatientTreatment updatedPatientTreatment = patientTreatmentMapper.mapPTdtoToPT(patientTreatment);
        return patientTreatmentMapper.mapPTtoPTdto(patientTreatmentRepository.save(updatedPatientTreatment));
    }

    public void deletePatientTreatment(Integer id) {
        patientTreatmentRepository.deleteById(id);
    }


    public List<PatientTreatmentDTO> findFiltered(String patientName, String treatmentName, String inserterName, String location, String date) {
        return patientTreatmentRepository.findFiltered(patientName, treatmentName, inserterName, location, date)
                .stream()
                .map(patientTreatmentMapper::mapPTtoPTdto)
                .collect(Collectors.toList());
    }
>>>>>>> Stashed changes
}
