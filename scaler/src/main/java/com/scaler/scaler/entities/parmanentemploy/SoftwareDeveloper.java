package com.scaler.scaler.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "developer")
public class SoftwareDeveloper  extends PermanentEmployee{
    private Long leavesTaken;
}
