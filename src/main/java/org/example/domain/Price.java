package org.example.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Price extends BaseModel {

    private final String externalId;
    private final double eur;
    private final double gbp;
}
