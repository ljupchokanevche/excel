package org.example.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Specification {
    private final String consumption;
    private final String capacity;
    private final String designer;
}
