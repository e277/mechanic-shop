package dev.ungu.mechanicshop.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Vehicle {
    
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String color;
    private LocalDateTime dropped_off;
    private LocalDateTime picked_up;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    // Fields to store foreign key values
    @Transient
    private Long customer_id;
    
    @Transient
    private Long mechanic_id;

    // Constructors
    public Vehicle() {

    }

    public Vehicle(Long id, String model, String color, String dropped_off, String picked_up) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.dropped_off = LocalDateTime.parse(dropped_off);
        this.picked_up = LocalDateTime.parse(picked_up);
    }


    // Getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getDropped_off() {
        return this.dropped_off;
    }

    public void setDropped_off(LocalDateTime dropped_off) {
        this.dropped_off = dropped_off;
    }

    public LocalDateTime getPicked_up() {
        return this.picked_up;
    }

    public void setPicked_up(LocalDateTime picked_up) {
        this.picked_up = picked_up;
    }

    // public void setMechanic(Mechanic mechanic) {
    //     this.mechanic = mechanic;
    //     if (mechanic != null) {
    //         this.mechanic_id = mechanic.getId();
    //     } else {
    //         this.mechanic_id = null;
    //     }
    // }

    // public void setCustomer(Customer customer) {
    //     this.customer = customer;
    //     if (customer != null) {
    //         this.customer_id = customer.getId();
    //     } else {
    //         this.customer_id = null;
    //     }
    // }

    // Getter for customer_id
    public Long getCustomer_id() {
        return this.customer_id;
    }

    // Getter for mechanic_id
    public Long getMechanic_id() {
        return this.mechanic_id;
    }
}
