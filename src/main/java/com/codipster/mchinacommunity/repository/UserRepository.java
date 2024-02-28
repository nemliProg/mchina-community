package com.codipster.mchinacommunity.repository;

import com.codipster.mchinacommunity.enums.Status;
import com.codipster.mchinacommunity.mongodocs.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String id);
    Optional<User> findByUsername(String username);
    List<User> findAllByStatus(Status status);
}
