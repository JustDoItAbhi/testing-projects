package com.cancelorder.cancelorder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Address extends BaseModel {
    private String number;
    private String street;
    private String city;
    private String pincode;
    private String landmark;
    private String state;
    private Boolean isDefault;
    @ManyToMany(mappedBy = "addresses",fetch =  FetchType.LAZY,cascade= CascadeType.ALL)
    private List<Customer> customers;
}
