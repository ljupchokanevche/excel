package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Sustainability {

    public static final String SUSTAINABILITY_VALIDITY_PERIOD = "sustainability_validity_period";
    public static final String SUSTAINABILITY_NORMALIZED_GWD = "sustainability_normalized_GWD(piece CO2-eqv)";
    public static final String SUSTAINABILITY_GWD = "sustainability_GWD(piece CO2-eqv)";

    @JsonProperty(SUSTAINABILITY_GWD)
    private double gwd;

    @JsonProperty(SUSTAINABILITY_NORMALIZED_GWD)
    private double normalizedGwd;

    @JsonProperty(SUSTAINABILITY_VALIDITY_PERIOD)
    private String validityPeriod;
}
