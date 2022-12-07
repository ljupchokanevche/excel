package org.example.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Document {
    private final String other;
    private final String epd;
}
