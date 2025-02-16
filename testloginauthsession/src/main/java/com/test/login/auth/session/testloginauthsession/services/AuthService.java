package com.test.login.auth.session.testloginauthsession.services;

import com.test.login.auth.session.testloginauthsession.dtos.LoginRequest;
import com.test.login.auth.session.testloginauthsession.dtos.LoginResponse;
import com.test.login.auth.session.testloginauthsession.dtos.SignupRequest;
import com.test.login.auth.session.testloginauthsession.dtos.SignupResponse;
import com.test.login.auth.session.testloginauthsession.execptions.BadCredentialsException;
import com.test.login.auth.session.testloginauthsession.execptions.UserNotSignedUpException;
import com.test.login.auth.session.testloginauthsession.models.AuthCredential;
import com.test.login.auth.session.testloginauthsession.models.Session;
import com.test.login.auth.session.testloginauthsession.models.SessionState;
import com.test.login.auth.session.testloginauthsession.models.User;
import com.test.login.auth.session.testloginauthsession.repos.AuthCredentialRepo;
import com.test.login.auth.session.testloginauthsession.repos.SessionRepo;
import com.test.login.auth.session.testloginauthsession.repos.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthCredentialRepo authCredentialRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Override
    public SignupResponse signup(SignupRequest request) throws BadCredentialsException {
        Optional<AuthCredential>existingUser=authCredentialRepo.findAuthCredentialByEmail(request.getEmail());
        if(existingUser.isPresent()){
            throw new BadCredentialsException("USER ALREADY EXISTS");
        }
        AuthCredential credential=new AuthCredential();
        credential.setEmail(request.getEmail());
        credential.setPassword(request.getPassword());
        User user=new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setAuthCredential(credential);
        user.setPhoneNumber(request.getPhoneNumber());
        userRepo.save(user);
        authCredentialRepo.save(credential);
        return fromEntity(credential,user);
    }
    private static SignupResponse fromEntity(AuthCredential credential,User user){
        SignupResponse response=new SignupResponse();
        response.setEmail(credential.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws UserNotSignedUpException, BadCredentialsException {
        Optional<AuthCredential>existingUser=authCredentialRepo.findAuthCredentialByEmail(loginRequest.getEmail());
        if (existingUser.isEmpty()){
            throw new UserNotSignedUpException("user not found "+loginRequest.getEmail());
        }
        AuthCredential credential=existingUser.get();
        if(!credential.getPassword().equals(loginRequest.getPassword())){
            throw new BadCredentialsException("PASSWORD INCORECT "+loginRequest.getPassword());
        }
        Optional<User>savedUser=userRepo.findUserByAuthCredential(credential);
        if (savedUser.isEmpty()) {
            throw new UserNotSignedUpException("User data not found for " + loginRequest.getEmail());
        }
        Optional<Session>sessions=sessionRepo.findSessionByUser(savedUser.get());
        if(sessions.get().getSessionState().equals(SessionState.ACTIVE)){
            sessionRepo.deleteById(savedUser.get().getId());
        }
        Session session=new Session();
        session.setToken(getToken());
        session.setSessionState(SessionState.ACTIVE);

        session.setUser(savedUser.get());
        session.setTtl(new Date());
        sessionRepo.save(session);
            return fromEntityUserToLogin(savedUser.get());
    }
    private  LoginResponse fromEntityUserToLogin(User user) throws UserNotSignedUpException {
        LoginResponse response=new LoginResponse();
        response.setUserEmail(user.getAuthCredential().getEmail());
        long expiryTime = System.currentTimeMillis() + (2 * 24 * 60 * 60 * 1000); // 2 days validity
        response.setTokenValidity(new Date(expiryTime));
        Optional<Session>session=sessionRepo.findSessionByUser(user);
        if(session.isEmpty()){
            throw new UserNotSignedUpException("no session found ");
        }
        response.setToken(session.get().getToken());
return response;
    }

    private String getToken() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 15) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}

