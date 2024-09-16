package com.maletic.pacijentez.mapper;

import com.maletic.pacijentez.command.PatientTreatmentCommand;
import com.maletic.pacijentez.dto.PatientTreatmentDTO;
import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.model.Patient;
import com.maletic.pacijentez.model.PatientTreatment;
import com.maletic.pacijentez.model.Treatment;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientTreatmentMapper {

    private final ModelMapper modelMapper;

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

        Converter<PatientTreatmentCommand, Integer> toPatientTreatmentIdNull = new Converter<PatientTreatmentCommand, Integer>() {
            @Override
            public Integer convert(MappingContext<PatientTreatmentCommand, Integer> mappingContext) {
                return null;
            }
        };


    }

    public PatientTreatmentDTO mapPTtoPTdto(PatientTreatment patientTreatment) {
        return modelMapper.map(patientTreatment, PatientTreatmentDTO.class);
    }

    public PatientTreatment mapPTdtoToPT(PatientTreatmentDTO patientTreatmentDTO) {
        return modelMapper.map(patientTreatmentDTO, PatientTreatment.class);
    }

    public PatientTreatment mapCommandToEntity(PatientTreatmentCommand patientTreatmentCommand) {
        return modelMapper.map(patientTreatmentCommand, PatientTreatment.class);
    }

}
