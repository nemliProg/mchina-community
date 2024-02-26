package com.codipster.mchinacommunity.service;

import com.codipster.mchinacommunity.mongodocs.Comment;
import com.codipster.mchinacommunity.mongodocs.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment save(Comment comment);
    Comment getComment(String commentId);
    List<Comment> getAllComments();
    Comment updateComment(Comment comment);
    void deleteComment(String commentId);

}
