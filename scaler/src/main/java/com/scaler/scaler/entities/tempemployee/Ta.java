package com.scaler.scaler.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_A")
public class Ta extends ContractualEmployee {
    private Long numberOfHelpRequests;
}
