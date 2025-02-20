package com.scaler.scaler.entities.tempemployee;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
//@Table(name = "instructor")
public class Instructor extends ContractualEmployee {
    private String company;



}