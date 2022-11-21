package com.masay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "operator")
public class Operator extends User{

    private int poste;
    private String workplace;
}
