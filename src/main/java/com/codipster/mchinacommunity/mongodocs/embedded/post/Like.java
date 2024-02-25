package com.codipster.mchinacommunity.mongodocs.embedded.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Like {
    private String userId;
    private Date createdAt;

}
