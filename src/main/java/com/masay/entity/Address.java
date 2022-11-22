package com.masay.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    private String country;
    private String city;
    private String street;
    private Integer homeNumber;

    @OneToOne
    private User user;

    public Address() { }

    public Address(String country, String city, String street, Integer homeNumber) {

        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;

    }

    public void setId(Integer id) { this.id = id; }
    public void setCountry(String country) { this.country = country; }
    public void setCity(String city) { this.city = city; }
    public void setStreet(String street) { this.street = street; }
    public void setHomeNumber(Integer homeNumber) { this.homeNumber = homeNumber; }
    public void setUser(User user) { this.user = user; }

    public Integer getId() { return id; }
    public String getCountry() { return country; }
    public String getCity() { return city; }
    public String getStreet() { return street; }
    public Integer getHomeNumber() { return homeNumber; }
    public User getUser() { return user; }

}
