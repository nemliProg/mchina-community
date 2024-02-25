package com.codipster.mchinacommunity.repository;

import com.codipster.mchinacommunity.mongodocs.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findById(String id);
    Optional<Role> findByRoleName(String roleName);
}
