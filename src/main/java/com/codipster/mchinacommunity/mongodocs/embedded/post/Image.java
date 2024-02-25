package com.codipster.mchinacommunity.mongodocs.embedded.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Image {
    private String imageId;
    private String imagePath;
}
