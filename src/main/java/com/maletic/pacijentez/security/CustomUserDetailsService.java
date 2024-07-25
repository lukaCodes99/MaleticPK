package com.maletic.pacijentez.security;

import com.maletic.pacijentez.model.Employee;
import com.maletic.pacijentez.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //obratiti paznju na ovaj konstruktor tj nepostojanje konstruktora,
    // koristimo autowired da bi se izbjegla kružna ovisnost između security config i ovoga

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return new User(employee.getUsername(), employee.getPassword(), mapRoleToAuthority(employee));
    }

    private Collection<GrantedAuthority> mapRoleToAuthority(Employee employee) {
        return List.of(() -> employee.getRole().getName());
    }
}
