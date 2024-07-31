package com.maletic.pacijentez.mapper;


import com.maletic.pacijentez.dto.EmployeeDTO;
import com.maletic.pacijentez.dto.SetEmployeeDTO;
import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public EmployeeMapper(RoleRepository roleRepository) {
        this.modelMapper = new ModelMapper();
        this.roleRepository = roleRepository;
    }

    public EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee) {
        EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);
        dto.setRole(employee.getRole().getName());
        return dto;
    }

    public Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public Employee mapSetEmployeeDTOToEmployee(SetEmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        roleRepository.findByName(employeeDTO.getRole()).ifPresent(employee::setRole);
        return employee;
    }
}
