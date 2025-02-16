package com.test.login.auth.session.testloginauthsession.repos;

import com.test.login.auth.session.testloginauthsession.models.AuthCredential;
import com.test.login.auth.session.testloginauthsession.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByAuthCredential(AuthCredential authCredential);
}
