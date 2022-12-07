package org.example.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PhysicalMeasurement {
    private final int depth;
    private final int width;
    private final int height;
}
