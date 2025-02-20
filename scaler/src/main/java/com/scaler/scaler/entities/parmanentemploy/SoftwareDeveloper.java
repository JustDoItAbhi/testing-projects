package com.scaler.scaler.entities.parmanentemploy;

import com.scaler.scaler.entities.Employee;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "developer")
public class SoftwareDeveloper extends PermanentEmployee {
    private Long leavesTaken;
}
