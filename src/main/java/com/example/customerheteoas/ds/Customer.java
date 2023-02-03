package com.example.customerheteoas.ds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList<>();

    public Customer() {
    }

    public void addAddress(Address address){
        address.setCustomer(this);
        addresses.add(address);
    }

    public Customer(String code, String firstName, String lastName, String email) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
