package com.instagram.cardinality.check.instagramcardinalitycheck.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Entity
@Data
public class InstagramPost {
    @Id
    private UUID id;
    @ManyToOne
    private InstagramPage instagramPage;
    @OneToMany
    private List<InstagramLike> instagramLikes;
    @OneToMany
    private List<InstagramComment> instagramComments;

    private String content;
}
