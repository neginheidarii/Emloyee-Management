package tech.getarrays.employeemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

// Serializable to make it converted to different streams
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;
}
