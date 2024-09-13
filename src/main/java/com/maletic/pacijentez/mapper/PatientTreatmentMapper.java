package com.maletic.pacijentez.mapper;

<<<<<<< Updated upstream
public class PatientTreatmentMapper {

=======
import com.maletic.pacijentez.dto.PatientTreatmentDTO;
import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.model.Patient;
import com.maletic.pacijentez.model.PatientTreatment;
import com.maletic.pacijentez.model.Treatment;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class PatientTreatmentMapper {

    private ModelMapper modelMapper;

    public PatientTreatmentMapper() {
        this.modelMapper = new ModelMapper();

        Converter<Patient, String> toPatientFullName = new Converter<Patient, String>() {
            @Override
            public String convert(MappingContext<Patient, String> mappingContext) {
                Patient patient = mappingContext.getSource();
                return patient != null ? patient.getFirstName() + " " + patient.getLastName() : null;
            }

        };

        Converter<Employee, String> toEmployeeFullName = new Converter<Employee, String>() {
            @Override
            public String convert(MappingContext<Employee, String> mappingContext) {
                Employee employee = mappingContext.getSource();
                return employee != null ? employee.getFirstName() + " " + employee.getLastName() : null;
            }
        };



        this.modelMapper.typeMap(PatientTreatment.class, PatientTreatmentDTO.class)
                .addMappings(mapper -> {
                    mapper.using(toPatientFullName).map(PatientTreatment::getPatientId, PatientTreatmentDTO::setPatientFullName);
                    mapper.using(toEmployeeFullName).map(PatientTreatment::getInserterId, PatientTreatmentDTO::setInserterFullName);
                    mapper.map(src -> src.getTreatmentId().getName(), PatientTreatmentDTO::setTreatmentName);
                });
    }

    public PatientTreatmentDTO mapPTtoPTdto(PatientTreatment patientTreatment) {
        return modelMapper.map(patientTreatment, PatientTreatmentDTO.class);
    }

    public PatientTreatment mapPTdtoToPT(PatientTreatmentDTO patientTreatmentDTO) {
        return modelMapper.map(patientTreatmentDTO, PatientTreatment.class);
    }
>>>>>>> Stashed changes
}
