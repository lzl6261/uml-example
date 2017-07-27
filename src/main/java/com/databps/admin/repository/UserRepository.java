package com.databps.admin.repository;

import com.databps.admin.domain.User2;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the User entity.
 */
@Repository
public interface UserRepository extends MongoRepository<User2, String> {

    Optional<User2> findOneByActivationKey(String activationKey);

    List<User2> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<User2> findOneByResetKey(String resetKey);

    Optional<User2> findOneByEmail(String email);

    Optional<User2> findOneByLogin(String login);

    Page<User2> findAllByLoginNot(Pageable pageable, String login);
}
