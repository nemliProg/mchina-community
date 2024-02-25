package com.codipster.mchinacommunity.mongodocs.embedded.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Link {
    private String linkId;
    private String placeholder;
    private String url;
}
