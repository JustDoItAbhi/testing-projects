package com.scaler.scaler.entities.parmanentemploy;

import com.scaler.scaler.entities.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "program_manager")
public class ProgramManager extends PermanentEmployee {
    @Column(name="FEATURES_COMPLETED")
    private Long featuresCompleted;
}
