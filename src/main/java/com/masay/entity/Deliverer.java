package com.masay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "deliverers")
public class Deliverer extends User{

    public Deliverer() { }

    public Deliverer(String name, String email, String phone, String password, String role) {

        super(name, email, phone, password, role);

    }

}
