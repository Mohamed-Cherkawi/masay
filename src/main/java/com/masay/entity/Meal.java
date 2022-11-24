package com.masay.entity;

import jakarta.persistence.*;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private float price;
    private String description;
    @ManyToOne
    private Restaurant restaurant;

    public Meal() {

    }
    public Meal(String name, String type, float price, String description, Restaurant restaurant) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }
    public Meal(int id, String name, String type, float price, String description, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id=" + id +
                ",\n name=" + name  +
                ",\n type=" + type +
                ",\n price=" + price + " $" +
                ",\n description=" + description  +
                ",\n restaurantName=" + restaurant.getName() +
                "\n}";
    }
}