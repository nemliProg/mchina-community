package com.codipster.mchinacommunity.mongodocs;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String text;
    private Date createdAt;
    @DBRef
    private User user;
    @DBRef
    private Post post;
    @DBRef
    private Comment parentComment;
}
