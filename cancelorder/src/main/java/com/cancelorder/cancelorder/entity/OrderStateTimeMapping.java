package com.cancelorder.cancelorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class OrderStateTimeMapping extends BaseModel {
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    private Date date = new Date();
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;
}
