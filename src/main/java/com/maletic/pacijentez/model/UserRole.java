package com.maletic.pacijentez.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserRole")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
