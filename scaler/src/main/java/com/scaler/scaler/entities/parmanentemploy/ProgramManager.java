package com.scaler.scaler.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "program_manager")
public class ProgramManager extends PermanentEmployee {
    @Column(name="FEATURES_COMPLETED")
    private Long featuresCompleted;
}
