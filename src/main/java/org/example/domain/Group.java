package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Builder;

@Builder
@Getter
public class Group {

    public static final String GROUP_RANGE = "group:Range";
    public static final String GROUP_FAMILY = "group:Family";
    public static final String GROUP_COLLECTION = "group:Collection";
    public static final String GROUP_CATEGORY = "group:Category";
    @JsonProperty(GROUP_RANGE)
    private final String range;

    @JsonProperty(GROUP_FAMILY)
    private final String family;

    @JsonProperty(GROUP_COLLECTION)
    private final String collection;

    @JsonProperty(GROUP_CATEGORY)
    private final String category;
}
