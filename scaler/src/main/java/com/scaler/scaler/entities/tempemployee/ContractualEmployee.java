package com.scaler.scaler.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ContractualEmployee extends Employee {

    private String alias;

    private  Double hourlyRenumeration;
}