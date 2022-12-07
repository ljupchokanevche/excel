package org.example.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class DistributionUnit extends ConsumerUnit {

    public static final String DISTRIBUTION_UNIT_WIDTH = "distribution_unit:width";
    public static final String DISTRIBUTION_UNIT_LENGTH = "distribution_unit:length";
    public static final String DISTRIBUTION_UNIT_HEIGHT = "distribution_unit:height";
    public static final String DISTRIBUTION_UNIT_VOLUME = "distribution_unit:volume";

    private final double volume;

}
