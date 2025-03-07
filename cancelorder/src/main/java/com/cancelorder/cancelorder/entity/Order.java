package com.cancelorder.cancelorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="ORDERS")
public class Order extends BaseModel {
    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDetail> items;


    private Double totalCost;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OrderStateTimeMapping> orderTimeline;
}
