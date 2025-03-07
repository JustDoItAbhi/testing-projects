package com.cancelorder.cancelorder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ItemDetail extends BaseModel {
    @OneToOne
    private Item item;

    private Long quantity;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
