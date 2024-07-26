package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.dto.EmployeeDTO;
import com.maletic.pacijentez.dto.PasswordUpdateDTO;
import com.maletic.pacijentez.dto.SetEmployeeDTO;
import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveNewEmployee(@RequestBody SetEmployeeDTO employee){

        if(employeeService.exsistsByUsername(employee.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        EmployeeDTO savedEmployeeDTO = employeeService.saveEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody SetEmployeeDTO employee) {
        EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployee(employee);
        if (updatedEmployeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedEmployeeDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        boolean isUpdated = employeeService.updatePassword(passwordUpdateDTO.getEmployeeId(), passwordUpdateDTO.getOldPassword(), passwordUpdateDTO.getNewPassword());
        if (isUpdated) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid old password or employee not found");
        }
    }

}
