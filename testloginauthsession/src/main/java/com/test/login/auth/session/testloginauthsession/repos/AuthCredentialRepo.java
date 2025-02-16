package com.test.login.auth.session.testloginauthsession.repos;

import com.test.login.auth.session.testloginauthsession.models.AuthCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthCredentialRepo extends JpaRepository<AuthCredential,String> {
    Optional<AuthCredential> findAuthCredentialByEmail(String email);
}
