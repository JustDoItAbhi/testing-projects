package com.test.login.auth.session.testloginauthsession.controllers;

import com.test.login.auth.session.testloginauthsession.dtos.LoginRequest;
import com.test.login.auth.session.testloginauthsession.dtos.LoginResponse;
import com.test.login.auth.session.testloginauthsession.dtos.SignupRequest;
import com.test.login.auth.session.testloginauthsession.dtos.SignupResponse;
import com.test.login.auth.session.testloginauthsession.execptions.BadCredentialsException;
import com.test.login.auth.session.testloginauthsession.execptions.UserNotSignedUpException;
import com.test.login.auth.session.testloginauthsession.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    //Add APIs here.
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signUp(@RequestBody SignupRequest request) throws BadCredentialsException {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws UserNotSignedUpException, BadCredentialsException {
        return ResponseEntity.ok(authService.login(request));
    }
}
