package com.codipster.mchinacommunity.mongodocs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String roleName;

}
