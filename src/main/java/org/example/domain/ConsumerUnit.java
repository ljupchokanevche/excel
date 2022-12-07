package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ConsumerUnit {

    public static final String CONSUMER_UNIT_WIDTH = "consumer_unit:width";
    public static final String CONSUMER_UNIT_LENGTH = "consumer_unit:length";
    public static final String CONSUMER_UNIT_HEIGHT = "consumer_unit:height";

    @JsonProperty(CONSUMER_UNIT_LENGTH)
    private final double length;

    @JsonProperty(CONSUMER_UNIT_WIDTH)
    private final double width;

    @JsonProperty(CONSUMER_UNIT_HEIGHT)
    private final double height;
}
