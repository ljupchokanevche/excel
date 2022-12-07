package org.example.domain;

import lombok.Getter;
import lombok.Builder;

@Builder
@Getter
public class Model {
    private final String other;
    private final String dwg;
    private final String sketchUp;
    private final String revit;
    private final String ifc;
}
