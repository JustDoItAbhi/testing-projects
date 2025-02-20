package com.scaler.scaler.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parmanent_employee")
public class PermanentEmployee extends Employee {
    @Id
    private String email;
    @Column(name="COST_TO_COMPANY")
    private Double costToCompany;
}
