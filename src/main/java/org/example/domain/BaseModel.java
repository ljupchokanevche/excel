package org.example.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@SuperBuilder
@Getter
@RequiredArgsConstructor
public class BaseModel {

    @Singular("data")
    private final Map<String, String> otherData;
}
