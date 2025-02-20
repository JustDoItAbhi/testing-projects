package com.scaler.scaler.entities.tempemployee;

import jakarta.persistence.*;

@Entity
//@Table(name = "T_A")
//@DiscriminatorValue("T_A")
public class Ta extends ContractualEmployee {
    @Column(name = "NUMBER_OF_HELP_REQUESTS")
    private Long numberOfHelpRequests;

}
