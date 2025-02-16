package com.students.teachers.compositkey.studentteacherrating.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Categorys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="category_name")
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<Products> product = new HashSet<>();

    //if product is added then category also added
    public void addProduct(Products products) {
        product.add(products);
        products.setCategory(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Products> getProduct() {
        return product;
    }

    public void setProduct(Set<Products> product) {
        this.product = product;
    }
}
