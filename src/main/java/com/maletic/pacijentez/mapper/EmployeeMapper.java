package com.maletic.pacijentez.mapper;


import com.maletic.pacijentez.dto.EmployeeDTO;
import com.maletic.pacijentez.dto.SetEmployeeDTO;
import com.maletic.pacijentez.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private ModelMapper modelMapper;

    public EmployeeMapper() {
        this.modelMapper = new ModelMapper();
    }

    public EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee) {
        EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);
        dto.setRole(employee.getRole().getName());
        return dto;
    }

    public Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public Employee mapSetEmployeeDTOToEmployee(SetEmployeeDTO employee) {
        return modelMapper.map(employee, Employee.class);
    }
}
