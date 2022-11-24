package com.masay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends User {

    @OneToMany()
    private List<Order> orders;
    public Customer() {
    }

    public Customer(String name, String email, String phone, String password, String role) {
        super(name, email, phone, password, role);
    }
}