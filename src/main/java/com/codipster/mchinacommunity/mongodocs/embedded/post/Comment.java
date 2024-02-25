package com.codipster.mchinacommunity.mongodocs.embedded.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Comment {
    private String commentId;
    private String comment;
    private Date createdAt;
    private String userId;
    private List<Comment> replies;
    private List<Like> likes;
}
