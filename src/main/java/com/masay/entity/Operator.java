package com.masay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "operators")
public class Operator extends User {

    public Operator() { }

    public Operator(String name, String email, String phone, String password, String role) {

        super(name, email, phone, password, role);

    }

}
