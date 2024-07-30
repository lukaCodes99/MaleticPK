package com.maletic.pacijentez.service;


import com.maletic.pacijentez.dto.EmployeeDTO;
import com.maletic.pacijentez.dto.SetEmployeeDTO;
import com.maletic.pacijentez.mapper.EmployeeMapper;
import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public EmployeeDTO saveEmployee(SetEmployeeDTO employee) {

        Employee employeeToSave = employeeMapper.mapSetEmployeeDTOToEmployee(employee);
        employeeToSave.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeMapper.mapEmployeeToEmployeeDTO(employeeRepository.save(employeeToSave));
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::mapEmployeeToEmployeeDTO).collect(Collectors.toList());
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeeDTO updateEmployee(SetEmployeeDTO employeeDTO) {
        if(employeeRepository.findById(employeeDTO.getId()).isEmpty()){
            return null;
        }

        Employee savedEmployee = employeeMapper.mapSetEmployeeDTOToEmployee(employeeDTO);
        savedEmployee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        return employeeMapper.mapEmployeeToEmployeeDTO(employeeRepository.save(savedEmployee));
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public boolean exsistsByUsername(String username) {
        return employeeRepository.existsByUsername(username);
    }

    public boolean updatePassword(Integer employeeId, String oldPassword, String newPassword) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null || !passwordEncoder.matches(oldPassword, employee.getPassword())) {
            return false;
        }
        employee.setPassword(passwordEncoder.encode(newPassword));
        employeeRepository.save(employee);
        return true;
    }
}
