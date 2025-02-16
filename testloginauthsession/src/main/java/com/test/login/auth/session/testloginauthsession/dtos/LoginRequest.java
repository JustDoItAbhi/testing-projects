package com.test.login.auth.session.testloginauthsession.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
