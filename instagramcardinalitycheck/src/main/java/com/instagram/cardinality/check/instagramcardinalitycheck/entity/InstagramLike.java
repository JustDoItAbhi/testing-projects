package com.instagram.cardinality.check.instagramcardinalitycheck.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;
@Entity
@Data
public class InstagramLike {
    @Id
    private UUID id;
    @ManyToOne
    private InstagramPost post;
    @ManyToOne
    private InstagramUser user;
}
