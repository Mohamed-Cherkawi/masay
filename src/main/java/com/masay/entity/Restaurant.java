package com.masay.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Operator operator;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Meal> meals = new ArrayList<>();

    public Restaurant() { }

    public Restaurant(String name) { this.name = name; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setOperator(Operator operator) { this.operator = operator; }
    public void setMeals(List<Meal> meals) { this.meals = meals; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Operator getOperator() { return operator; }
    public List<Meal> getMeals() { return meals; }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
