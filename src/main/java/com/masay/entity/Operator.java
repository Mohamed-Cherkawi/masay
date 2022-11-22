package com.masay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "operators")
public class Operator extends User {

    private String position;

    public Operator() { }

    public Operator(String name, String email, String phone, String password, String role, String position) {

        super(name, email, phone, password, role);

        this.position = position;

    }

    public void setPosition(String position) { this.position = position; }

    public String getPosition() { return position; }

}
