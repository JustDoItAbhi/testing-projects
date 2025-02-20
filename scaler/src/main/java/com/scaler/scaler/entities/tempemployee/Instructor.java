package com.scaler.scaler.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor extends ContractualEmployee{
    private String company;
}