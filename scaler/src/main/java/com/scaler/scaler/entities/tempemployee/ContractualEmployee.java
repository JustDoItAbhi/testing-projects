package com.scaler.scaler.entities.tempemployee;

import com.scaler.scaler.entities.Employee;
import jakarta.persistence.*;

//@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "CONTRACTUAL_EMPLOYEE")
public abstract class ContractualEmployee extends Employee {
//    @Id
    @Column(name = "ALIAS", unique = true, nullable = false)
    private String alias;
    @Column(name = "HOURLY_RENUMERATION")
    private  Double hourlyRenumeration;

}