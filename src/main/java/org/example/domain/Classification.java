package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Builder;

@Builder
@Getter
public class Classification {

    public static final String CLASSIFICATIONS_GPC = "classifications:GPC";

    @JsonProperty(CLASSIFICATIONS_GPC)
    private final Long gpc;
}
