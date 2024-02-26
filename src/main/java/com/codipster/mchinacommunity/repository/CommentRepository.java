package com.codipster.mchinacommunity.repository;

import com.codipster.mchinacommunity.mongodocs.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Optional<Comment> findById(String id);
    Optional<Comment> findByText(String text);
}
