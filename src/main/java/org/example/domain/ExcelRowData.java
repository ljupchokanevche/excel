package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * Entity for holding the row data and sheet name.
 */
@Getter
@RequiredArgsConstructor
public class ExcelRowData {

    @JsonProperty("document-type")
    private final String documentType;
    private final Map<String, String> data;
}
