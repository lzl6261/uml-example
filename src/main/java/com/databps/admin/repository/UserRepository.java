package com.databps.admin.repository;

import com.databps.admin.domain.Admin;
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
public interface UserRepository extends MongoRepository<Admin, String> {

    Optional<Admin> findOneByActivationKey(String activationKey);

    List<Admin> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<Admin> findOneByResetKey(String resetKey);

    Optional<Admin> findOneByEmail(String email);

    Optional<Admin> findOneByLogin(String login);

    Page<Admin> findAllByLoginNot(Pageable pageable, String login);
}
