package org.example.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Entity for processing the post request body.
 */
@Getter
@RequiredArgsConstructor
public class PostRequestModel {

    private final UUID transaction;
    private final LocalDate date;
    private final List<ExcelRowData> objects;
}
