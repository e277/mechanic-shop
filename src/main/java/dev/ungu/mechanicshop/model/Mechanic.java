package dev.ungu.mechanicshop.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Mechanic {
    
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty; // Technician, Transmission, Tire.

    @OneToMany(mappedBy = "mechanic", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;


    // Constructors
    public Mechanic() {

    }

    public Mechanic(Long id, String name, String speciality) {
        this.id = id;
        this.name = name;
        this.specialty = speciality;
    }


    // Getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return this.specialty;
    }

    public void setSpeciality(String speciality) {
        this.specialty = speciality;
    }

}
