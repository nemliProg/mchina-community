package com.codipster.mchinacommunity.mongodocs.embedded.post;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {
    private String imageId;
    private String imagePath;
    private String imageDescription;
}
