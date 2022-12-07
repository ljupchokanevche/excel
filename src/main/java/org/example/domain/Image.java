package org.example.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Image extends BaseModel {

    private final String externalId;
    private final String productImage;
}
