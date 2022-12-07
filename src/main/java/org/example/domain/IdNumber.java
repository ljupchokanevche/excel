package org.example.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IdNumber {
    private final Long nobb;
    private final Long finfo;
}
