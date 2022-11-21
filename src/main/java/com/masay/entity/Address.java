package com.masay.entity;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String country;
    private String city;
    private String street;
    @Column(nullable = false)
    @OneToOne
    private User user;
    private String housing_type;
    private int house_number ;
}
