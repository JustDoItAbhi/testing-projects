package com.cancelorder.cancelorder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Item extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Boolean isPremium;
    @OneToOne
    private Inventory inventory;
}
