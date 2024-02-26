package com.codipster.mchinacommunity.mongodocs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "likes")
public class Like {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Object likedEntity;
    private String entityType;

    // setter for likedEntity
    public void setLikedEntity(Object likedEntity) {
        if (likedEntity instanceof Post) {
            this.likedEntity = (Post) likedEntity;
            this.entityType = "Post";
        } else if (likedEntity instanceof Comment) {
            this.likedEntity = (Comment) likedEntity;
            this.entityType = "Comment";
        }else {
            throw new IllegalArgumentException("Invalid type of likedEntity");
        }
    }

    @Builder
    public static Like customLikeBuilder(User user, Object likedEntity) {
        Like like = new Like();
        like.setUser(user);
        if (likedEntity instanceof Post) {
            like.setLikedEntity(likedEntity);
            like.setEntityType("Post");
        } else if (likedEntity instanceof Comment) {
            like.setLikedEntity(likedEntity);
            like.setEntityType("Comment");
        } else {
            throw new IllegalArgumentException("Invalid type of likedEntity");
        }
        return like;
    }
}
