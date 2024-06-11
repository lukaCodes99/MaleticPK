package com.maletic.pacijentez.service;


import com.maletic.pacijentez.dto.EmployeeDTO;
import com.maletic.pacijentez.mapper.EmployeeMapper;
import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    public EmployeeDTO saveEmployee(EmployeeDTO employee) {

        Employee savedEmployee = employeeRepository.save(employeeMapper.mapEmployeeDTOToEmployee(employee));
        return employeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::mapEmployeeToEmployeeDTO).collect(Collectors.toList());
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepository.findById(employeeDTO.getId()).isEmpty()){
            return null;
        }
        Employee savedEmployee = employeeRepository.save(employeeMapper.mapEmployeeDTOToEmployee(employeeDTO));
        return employeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
