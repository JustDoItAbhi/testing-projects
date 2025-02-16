package com.test.login.auth.session.testloginauthsession.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name="USER_LOGIN_SESSIONS")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@OneToOne
    private User user;

    private String token;

    private Date ttl;
    @Enumerated(EnumType.STRING)
    private SessionState sessionState;
}
