package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ExcelRowData {

    @JsonProperty("document-type")
    private final String documentType;
    private final BaseModel data;
}
