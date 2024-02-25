package com.codipster.mchinacommunity.mongodocs;

import com.codipster.mchinacommunity.mongodocs.embedded.post.Comment;
import com.codipster.mchinacommunity.mongodocs.embedded.post.Image;
import com.codipster.mchinacommunity.mongodocs.embedded.post.Like;
import com.codipster.mchinacommunity.mongodocs.embedded.post.Link;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String textContent;
    private Date createdAt = new Date();

    @DBRef
    private User user;

    private List<Image> images;
    private List<Link> links;
    private List<String> hashtags;
    private List<Comment> comments;
    private List<Like> likes;

}
