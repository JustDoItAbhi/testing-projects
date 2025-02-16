package com.test.login.auth.session.testloginauthsession.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AuthCredential {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;
    private String password;
}
