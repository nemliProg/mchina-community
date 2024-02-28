package com.codipster.mchinacommunity.mongodocs;

import com.codipster.mchinacommunity.enums.Roles;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "roles")
public class Role {
    @Id
    private Roles role;

}
