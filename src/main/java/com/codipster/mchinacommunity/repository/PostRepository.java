package com.codipster.mchinacommunity.repository;

import com.codipster.mchinacommunity.mongodocs.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findByPostId(String postId);
}
