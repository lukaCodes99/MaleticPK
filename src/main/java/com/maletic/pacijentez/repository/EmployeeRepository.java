package com.maletic.pacijentez.repository;

import com.maletic.pacijentez.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Query("SELECT e FROM Employee e where e.role.name LIKE CONCAT('%', LOWER(:roleParam), '%')")
    List<Employee> findAllByUsersByRole(@Param("roleParam") String role);
}
