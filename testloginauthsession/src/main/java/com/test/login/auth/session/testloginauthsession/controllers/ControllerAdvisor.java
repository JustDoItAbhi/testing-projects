package com.test.login.auth.session.testloginauthsession.controllers;

import com.test.login.auth.session.testloginauthsession.execptions.BadCredentialsException;
import com.test.login.auth.session.testloginauthsession.execptions.UserNotSignedUpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({BadCredentialsException.class, UserNotSignedUpException.class})
    public ResponseEntity<String> handleBadRequests(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

