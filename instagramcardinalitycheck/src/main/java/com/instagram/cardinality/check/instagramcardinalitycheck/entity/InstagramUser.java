package com.instagram.cardinality.check.instagramcardinalitycheck.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.*;
@Entity
@Data
public class InstagramUser {
    @Id
    private UUID id;

    private String name;
    @OneToMany
    private Set<InstagramPage> pages = new HashSet<>();
    @OneToMany
    private List<InstagramLike> instagramLikes = new ArrayList<>();
    @OneToMany
    private List<InstagramComment> instagramComments = new ArrayList<>();
}
