package com.instagram.cardinality.check.instagramcardinalitycheck.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Data
public class InstagramPage {
    @Id
    private UUID id;
    @OneToMany
    private Set<InstagramPost> posts = new HashSet<>();
    @ManyToOne
    private InstagramUser creator;
}
