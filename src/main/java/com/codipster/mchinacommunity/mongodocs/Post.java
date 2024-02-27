package com.codipster.mchinacommunity.mongodocs;

import com.codipster.mchinacommunity.mongodocs.embedded.post.Image;
import com.codipster.mchinacommunity.mongodocs.embedded.post.Link;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String textContent;
    private Date createdAt;
    @DBRef
    private User user;
    private List<Image> images;
    private List<Link> links;
    private List<String> hashtags;

}
