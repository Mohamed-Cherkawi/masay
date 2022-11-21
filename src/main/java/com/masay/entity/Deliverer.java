package com.masay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "deliverer")
public class Deliverer extends User{

    private String transport;
}
