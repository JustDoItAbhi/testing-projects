package com.test.login.auth.session.testloginauthsession.repos;

import com.test.login.auth.session.testloginauthsession.models.Session;
import com.test.login.auth.session.testloginauthsession.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {
    Optional<Session> findSessionByUser(User user);
}
