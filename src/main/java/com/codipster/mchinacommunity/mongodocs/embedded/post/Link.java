package com.codipster.mchinacommunity.mongodocs.embedded.post;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Link {
    private String linkId;
    private String placeholder;
    private String url;
}
