package com.test.login.auth.session.testloginauthsession.services;

import com.test.login.auth.session.testloginauthsession.dtos.LoginRequest;
import com.test.login.auth.session.testloginauthsession.dtos.LoginResponse;
import com.test.login.auth.session.testloginauthsession.dtos.SignupRequest;
import com.test.login.auth.session.testloginauthsession.dtos.SignupResponse;
import com.test.login.auth.session.testloginauthsession.execptions.BadCredentialsException;
import com.test.login.auth.session.testloginauthsession.execptions.UserNotSignedUpException;

public interface IAuthService {
    SignupResponse signup(SignupRequest request) throws BadCredentialsException;

    LoginResponse login(LoginRequest loginRequest) throws UserNotSignedUpException, BadCredentialsException;
}
