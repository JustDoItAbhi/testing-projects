package com.cancelorder.cancelorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Customer {
    @Id
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMERS_ADDRESSES",
            joinColumns = @JoinColumn(name="CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name="ADDRESS_ID"))
    private List<Address> addresses;

    private String email;

    private String password;
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Order> orders;

    private Long orderCancellationCount;
}
