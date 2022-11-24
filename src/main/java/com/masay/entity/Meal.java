package com.masay.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "meals", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customers = new ArrayList<>();

    public Meal() { }

    public Meal( String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(Integer price) { this.price = price; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getPrice() { return price; }
    public Restaurant getRestaurant() { return restaurant; }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
