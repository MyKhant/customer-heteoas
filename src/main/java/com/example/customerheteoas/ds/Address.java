package com.example.customerheteoas.ds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String streetNumber;
    private String streetName;
    private String city;
    private String aptNumber;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    public Address() {
    }

    public Address(String streetNumber, String streetName, String city, String aptNumber) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.aptNumber = aptNumber;
    }
}
