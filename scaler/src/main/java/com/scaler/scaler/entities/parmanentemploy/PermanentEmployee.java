package com.scaler.scaler.entities.parmanentemploy;

import com.scaler.scaler.entities.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "parmanent_employee")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class PermanentEmployee extends Employee {
//    @Id
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;
    @Column(name="COST_TO_COMPANY")
    private Double costToCompany;
}
