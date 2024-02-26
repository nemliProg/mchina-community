package com.codipster.mchinacommunity.repository;

import com.codipster.mchinacommunity.mongodocs.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends MongoRepository<Like, String> {
    Optional<Like> findById(String id);

}
