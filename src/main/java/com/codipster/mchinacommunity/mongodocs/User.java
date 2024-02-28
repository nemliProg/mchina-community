package com.codipster.mchinacommunity.mongodocs;

import com.codipster.mchinacommunity.enums.Roles;
import com.codipster.mchinacommunity.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    @Id
    private String username;
    private String email;
    private String password;
    private Status status;
    private Roles role;

}